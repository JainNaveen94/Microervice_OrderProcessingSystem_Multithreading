package com.nagarro.microservices.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.microservices.model.Order;
import com.nagarro.microservices.service.OrderService;

@Component
public class OrderDTOImpl implements OrderDTO {
	
	@Autowired
	private OrderService orderService;

	@Override
	public Order getOrder(long orderId) {
		return this.orderService.getOrder(orderId);
	}

	@Override
	public List<Order> getOrders() {
		return this.orderService.getOrders();
	}

	@Override
	public List<Order> getOrdersOfUser(long userId) {
		return this.orderService.getOrdersOfuser(userId);
	}

}
