package com.nagarro.microservices.dto;

import java.util.List;

import com.nagarro.microservices.model.Order;

public interface OrderDTO {

	Order getOrder(long orderId);

	List<Order> getOrders();

	List<Order> getOrdersOfUser(long userId);

}
