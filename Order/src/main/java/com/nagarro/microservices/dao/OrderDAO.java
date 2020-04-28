package com.nagarro.microservices.dao;

import java.util.List;

import com.nagarro.microservices.model.Order;

public interface OrderDAO {

	List<Order> getOrders();

	Order getOrder(long orderId);

	List<Order> getOrdersOfUser(long userId);

}
