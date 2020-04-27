package com.nagarro.microservices.dto;

import com.nagarro.microservices.model.UserOrder;

public interface AggregatorDTO {

	UserOrder getUserOrders(long userId);

}
