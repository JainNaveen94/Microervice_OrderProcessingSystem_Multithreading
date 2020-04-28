package com.nagarro.microservices.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.microservices.services.OrderProcessingService;

@Component
public class OrderProcessingDTOImpl implements OrderProcessingDTO {
	
	@Autowired
	private OrderProcessingService orderProcessingService;
	
	

}
