package com.nagarro.microservices.dto;

import com.nagarro.microservices.model.OrderProcessModel;

public interface OrderProcessingDTO {

	OrderProcessModel processOrder(long orderId);

}
