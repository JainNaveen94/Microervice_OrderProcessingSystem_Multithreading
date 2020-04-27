package com.nagarro.microservices.service;

import com.nagarro.microservices.model.UserOrder;

public interface AggregatorService {

	UserOrder getUserOrders(long userId);

}
