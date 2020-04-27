package com.nagarro.microservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservices.constant.AggregatorConstant;
import com.nagarro.microservices.exception.custom.UserNotFoundException;
import com.nagarro.microservices.model.Order;
import com.nagarro.microservices.model.OrderDetail;
import com.nagarro.microservices.model.User;
import com.nagarro.microservices.model.UserOrder;
//import com.nagarro.microservices.service.proxy.OrderServiceProxy;
import com.nagarro.microservices.service.proxy.OrderServiceProxyImpl;
//import com.nagarro.microservices.service.proxy.UserServiceProxy;
import com.nagarro.microservices.service.proxy.UserServiceProxyImpl;

@Service
public class AggregatorServiceImpl implements AggregatorService {

	@Autowired
	private UserServiceProxyImpl userProxy;
//	private UserServiceProxy userProxy;

	@Autowired
	private OrderServiceProxyImpl orderProxy;
//	private OrderServiceProxy orderProxy;

	@Override
	public UserOrder getUserOrders(long userId) {
		User user = this.userProxy.getUser(userId);
		if (user != null) {
			List<Order> userOrders = this.orderProxy.getOrderListOfUser(userId);
			return this.buildUserOrderModel(user, userOrders);
		} else {
			throw new UserNotFoundException(AggregatorConstant.USER_NOT_FOUND + userId);
		}
	}

	// Build the UserOrder When User is Exist into the System.
	private UserOrder buildUserOrderModel(User user, List<Order> userOrders) {
		
		List<OrderDetail> userOrderDetails = this.buildUserOrderDetailFromUserOrder(userOrders);
		
		return new UserOrder(user.getId(), user.getName(), user.getAge(), 
				user.getEmail(), userOrderDetails);
	}

	// Build the OrderDetail Model List From Order Model List
	private List<OrderDetail> buildUserOrderDetailFromUserOrder(List<Order> userOrders) {
		List<OrderDetail> userOrderDetails = new ArrayList<OrderDetail>();
		
		for(Order order: userOrders) {
			userOrderDetails.add(new OrderDetail(order.getOrderId(), order.getOrderAmount(), order.getOrderDate()));
		}
		return userOrderDetails;
	}

}
