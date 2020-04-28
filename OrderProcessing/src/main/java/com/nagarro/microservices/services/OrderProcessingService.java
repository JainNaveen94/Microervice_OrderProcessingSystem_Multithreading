package com.nagarro.microservices.services;

import com.nagarro.microservices.model.OrderProcessModel;

public interface OrderProcessingService {

	OrderProcessModel processOrder(long orderId);

}
