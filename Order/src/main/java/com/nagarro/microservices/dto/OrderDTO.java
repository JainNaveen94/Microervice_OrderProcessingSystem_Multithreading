package com.nagarro.microservices.dto;

import java.util.List;

import com.nagarro.microservices.model.CumulativeOrderModel;
import com.nagarro.microservices.model.OrderModel;

public interface OrderDTO {

	OrderModel getOrder(long orderId);

	List<OrderModel> getOrders();

	List<OrderModel> getOrdersOfUser(long userId);

	List<OrderModel> getTopNOrdersBasesdOnAmount(long n);

	OrderModel getNthHighestOrderBasedOnAmount(int n);

	List<CumulativeOrderModel> getCumulativeOrderValueOfEachUser();

}
