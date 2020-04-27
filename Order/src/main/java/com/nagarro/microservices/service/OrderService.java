package com.nagarro.microservices.service;

import java.util.List;

import com.nagarro.microservices.model.Order;

public interface OrderService {

	Order getOrder(long orderId);

	List<Order> getOrders();

	List<Order> getOrdersOfuser(long userId);

}
