package com.nagarro.microservices.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservices.constant.OrderProcessingConstant;
import com.nagarro.microservices.exception.custom.CustomExceptionallyException;
import com.nagarro.microservices.model.OrderModel;
import com.nagarro.microservices.model.OrderProcessModel;
import com.nagarro.microservices.model.PaymentModel;
import com.nagarro.microservices.model.PaymentUpdateModel;
import com.nagarro.microservices.model.ProductModel;
import com.nagarro.microservices.model.ProductOrderedModel;
import com.nagarro.microservices.model.QuantityUpdateDTOModel;
import com.nagarro.microservices.model.UserModel;
import com.nagarro.microservices.service.proxy.OrderServiceProxyImpl;
import com.nagarro.microservices.service.proxy.PaymentServiceProxyImpl;
import com.nagarro.microservices.service.proxy.ProductServiceProxyImpl;
import com.nagarro.microservices.service.proxy.UserServiceProxyImpl;

import ch.qos.logback.classic.Logger;

@Service
public class OrderProcessingServiceImpl implements OrderProcessingService {

	private static Logger log = (Logger) LoggerFactory.getLogger(OrderProcessingServiceImpl.class);

	@Autowired
	private OrderServiceProxyImpl orderService;

	@Autowired
	private UserServiceProxyImpl userService;

	@Autowired
	private ProductServiceProxyImpl productService;

	@Autowired
	private PaymentServiceProxyImpl paymentService;

	@Autowired
	private Executor asyncExecutor;

	@SuppressWarnings("unused")
	@Override
	public OrderProcessModel processOrder(long orderId) {
		OrderProcessModel orderProcess = this.initilizeOrderProcessModel(orderId);
		CompletableFuture.supplyAsync(() -> {
			sleep(100);
			return this.getOrderDetailFromAPI(orderId);
		}, asyncExecutor).exceptionally((exception) -> {
			orderProcess.setMessage(exception.getMessage());
			return null;
		}).thenApplyAsync(order -> {
			if (order != null) {
				sleep(100);
				orderProcess.setUserId(order.getUserId());
				orderProcess.setOrderAmount(order.getAmount());
				UserModel user = this.getUserDetailFromAPI(order.getUserId());
				orderProcess.setUserName(user.getName());
				return order;
			} else {
				return null;
			}
		}, asyncExecutor).exceptionally((exception) -> {
			orderProcess.setMessage(exception.getMessage());
			return null;
		}).thenApplyAsync(order -> {
			if (order != null) {
				sleep(100);
				if (validateAvalabilityOfProducts(order.getProducts())) {
					return order;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}, asyncExecutor).exceptionally((exception) -> {
			orderProcess.setMessage(exception.getMessage());
			return null;
		}).thenApplyAsync(order -> {
			if (order != null) {
				sleep(100);
				if (validateUserPayment(order)) {
					return order;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}, asyncExecutor).exceptionally((exception) -> {
			orderProcess.setMessage(exception.getMessage());
			return null;
		}).thenAcceptAsync(order -> {
			if (order != null) {
				if (this.processTheValidOrder(order)) {
					orderProcess.setOrderStatus(true);
					orderProcess.setMessage(OrderProcessingConstant.ORDER_SUCCESS);
				} else {
					orderProcess.setMessage(OrderProcessingConstant.ORDER_FAILER);
				}
			}
		}, asyncExecutor).exceptionally((exception) -> {
			orderProcess.setMessage(exception.getMessage());
			return null;
		});

		sleep(1000);

		return orderProcess;
	}

	/******** Private Methods to Get the Data From Proxy Services ******/

	private OrderModel getOrderDetailFromAPI(long orderId) {
		OrderModel orderDetail = this.orderService.getOrder(orderId);
		if (orderDetail != null) {
			log.error("Order API Call To Fetech Order Detail :::: =====> {}", orderDetail.getUserId());
			return orderDetail;
		} else {
			throw new CustomExceptionallyException(OrderProcessingConstant.ORDER_INCORRECT_ID + orderId);
		}
	}

	private UserModel getUserDetailFromAPI(long userId) {
		UserModel userDetail = this.userService.getUser(userId);
		if (userDetail != null) {
			log.error("User API Call To Fetech User Detail :::: =====> {}", userDetail.getName());
			return userDetail;
		} else {
			throw new CustomExceptionallyException(OrderProcessingConstant.USER_INCORRECT_ID + userId);
		}
	}

	private ProductModel getProductDetailFromAPI(long productId) {
		ProductModel productDetail = this.productService.getProductById(productId);
		if (productDetail != null) {
			log.error("Product API Call To Fetech Product Detail :::: =====> {}", productDetail.getProductName());
			return productDetail;
		} else {
			throw new CustomExceptionallyException(OrderProcessingConstant.PRODUCTS_NOT_FOUND);
		}
	}

	private QuantityUpdateDTOModel updateProductQuantity(long productId, int quantity) {
		QuantityUpdateDTOModel updatedQuantity = this.productService.updateProductQuantity(productId, quantity);
		log.error("Product API Call To Update Quantity :::: =====> {}", updatedQuantity.getMessage());
		return updatedQuantity;
	}

	private PaymentModel getPaymentDetailFromAPI(long userId) {
		PaymentModel paymentDetail = this.paymentService.getPayment(userId);
		if (paymentDetail != null) {
			log.error("Payment API Call To Fetech Payment Detail :::: =====> {}", paymentDetail.getAmount());
			return paymentDetail;
		} else {
			throw new CustomExceptionallyException(OrderProcessingConstant.PAYMENT_INCORRECT_ID + userId);
		}
	}

	private PaymentUpdateModel updatePaymentAmount(long userId, double amountToBeDeducted) {
		PaymentUpdateModel updatePayment = this.paymentService.getUpdatedPayment(userId, amountToBeDeducted);
		log.error("Payment API Call To Update Amount :::: =====> {}", updatePayment.getMessage());
		return updatePayment;
	}

	/***** Other Private Service Methods *****/
	// just to sleep thread for some times
	public boolean sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException exception) {
			System.out.println(Thread.currentThread() + " : " + "time Out for Execution of Task");
		}
		return true;
	}

	// Initialize The OrderProcessModel Object
	public OrderProcessModel initilizeOrderProcessModel(long orderId) {
		return new OrderProcessModel(orderId, -1, "Not Found", 0, false, "");
	}

	// To Validate the Product Availabilitiy
	public boolean validateAvalabilityOfProducts(List<ProductOrderedModel> orderProducts) {

		for (ProductOrderedModel orderProduct : orderProducts) {
			try {
				ProductModel productInfo = this.getProductDetailFromAPI(orderProduct.getProductId());
				if (productInfo.getProductQuantity() < orderProduct.getProductQuantity()) {
					throw new CustomExceptionallyException(OrderProcessingConstant.INVALID_QUANTITY);
				}
			} catch (Exception exception) {
				throw new CustomExceptionallyException(OrderProcessingConstant.PRODUCTS_NOT_FOUND);
			}
		}
		return true;
	}

	// To Validate the User Payment Detail
	private boolean validateUserPayment(OrderModel order) {
		try {
			PaymentModel paymentInfo = this.getPaymentDetailFromAPI(order.getUserId());
			if (paymentInfo.getAmount() < order.getAmount()) {
				throw new CustomExceptionallyException(OrderProcessingConstant.PAYMENT_FAILED_INSUFFICENT);
			} else {
				return true;
			}
		} catch (CustomExceptionallyException exception) {
			throw new CustomExceptionallyException(OrderProcessingConstant.PAYMENT_FAILED_INSUFFICENT);
		} catch (Exception exception) {
			throw new CustomExceptionallyException(OrderProcessingConstant.PAYMENT_INCORRECT_ID + order.getUserId());
		}
	}

	// To Process the Valid Order
	private boolean processTheValidOrder(OrderModel order) {
		PaymentUpdateModel updatedPayment = this.updatePaymentAmount(order.getUserId(), order.getAmount());
		if (updatedPayment.getUpdateStatus()) {
			QuantityUpdateDTOModel udatedQuantityStatus = this.updateProductsQuantity(order.getProducts());
			if (udatedQuantityStatus.getUpdateStatus()) {
				return true;
			}
		}
		return false;
	}

	// To Update the Product Quantity
	private QuantityUpdateDTOModel updateProductsQuantity(List<ProductOrderedModel> orderProducts) {
		QuantityUpdateDTOModel udatedQuantityStatus = new QuantityUpdateDTOModel(false, "");
		for (ProductOrderedModel orderProduct : orderProducts) {
			udatedQuantityStatus = this.updateProductQuantity(orderProduct.getProductId(),
					orderProduct.getProductQuantity());
		}
		return udatedQuantityStatus;
	}

}
