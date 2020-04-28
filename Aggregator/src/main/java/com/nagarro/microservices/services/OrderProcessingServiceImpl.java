package com.nagarro.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservices.service.proxy.OrderServiceProxyImpl;
import com.nagarro.microservices.service.proxy.PaymentServiceProxyImpl;
import com.nagarro.microservices.service.proxy.ProductServiceProxyImpl;
import com.nagarro.microservices.service.proxy.UserServiceProxyImpl;

@Service
public class OrderProcessingServiceImpl implements OrderProcessingService {
	
	@Autowired
	private OrderServiceProxyImpl orderService;
	
	@Autowired
	private UserServiceProxyImpl userService;
	
	@Autowired
	private ProductServiceProxyImpl productService;
	
	@Autowired
	private PaymentServiceProxyImpl paymentService;
	
	
	
	
	
	
	/******** Private Methods to Get the Data From Proxy Services ******/

}
