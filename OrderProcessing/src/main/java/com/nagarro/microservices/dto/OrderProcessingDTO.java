package com.nagarro.microservices.dto;

import java.util.List;

import com.nagarro.microservices.model.OrderProcessModel;

public interface OrderProcessingDTO {

	OrderProcessModel processOrder(long orderId);

	List<OrderProcessModel> processOrderes(int[] orderIds);

}
