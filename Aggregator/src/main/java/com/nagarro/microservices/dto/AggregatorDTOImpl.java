package com.nagarro.microservices.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.microservices.model.UserOrder;
import com.nagarro.microservices.service.AggregatorService;

@Component
public class AggregatorDTOImpl implements AggregatorDTO {
	
	@Autowired
	private AggregatorService aggregatorService;

	@Override
	public UserOrder getUserOrders(long userId) {
		return this.aggregatorService.getUserOrders(userId);
	}

}
