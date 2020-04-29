package com.nagarro.microservices.services;

import java.util.List;

import com.nagarro.microservices.model.OrderProcessModel;

public interface OrderProcessingService {

	OrderProcessModel processOrder(long orderId);

	List<OrderProcessModel> processOrderes(int[] orderIds);

}
