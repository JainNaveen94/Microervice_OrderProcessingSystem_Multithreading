package com.nagarro.microservices.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.microservices.model.CumulativeOrderModel;
import com.nagarro.microservices.model.Order;
import com.nagarro.microservices.model.OrderModel;
import com.nagarro.microservices.service.OrderService;

@Component
public class OrderDTOImpl implements OrderDTO {
	
	@Autowired
	private OrderService orderService;

	@Override
	public OrderModel getOrder(long orderId) {
		return this.OrderToOrderModel(this.orderService.getOrder(orderId));
	}

	@Override
	public List<OrderModel> getOrders() {
		return this.orderListToOrderModelList(this.orderService.getOrders());
	}

	@Override
	public List<OrderModel> getOrdersOfUser(long userId) {
		return this.orderListToOrderModelList(this.orderService.getOrdersOfuser(userId));
	}
	
	@Override
	public List<OrderModel> getTopNOrdersBasesdOnAmount(long n) {
		return this.orderListToOrderModelList(this.orderService.getTopNOrdersBasesdOnAmount(n));
	}
	
	
	@Override
	public OrderModel getNthHighestOrderBasedOnAmount(int n) {
		return this.OrderToOrderModel(this.orderService.getNthHighestOrderBasedOnAmount(n));
	}
	
	@Override
	public List<CumulativeOrderModel> getCumulativeOrderValueOfEachUser() {
		return this.orderService.getCumulativeOrderValueOfEachUser();
	}
	
	/***** Private Object Mapper Methods *****/
	
	// Convert Order Object to OrderModel Object
	private OrderModel OrderToOrderModel(Order order) {
		return new OrderModel(order.getOrderId(), order.getOrderAmount(), order.getUserId(), order.getProducts());
	}
	
	// Convert List of Order Object to List of OrderModel Object
	private List<OrderModel> orderListToOrderModelList(List<Order> orders) {
		List<OrderModel> ordersModel = new ArrayList<OrderModel>();
		
		for(Order order: orders) {
			ordersModel.add(this.OrderToOrderModel(order));
		}
		
		return ordersModel;
	}

}
