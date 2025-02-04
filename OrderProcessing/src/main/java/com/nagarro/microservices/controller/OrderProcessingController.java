package com.nagarro.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.dto.OrderProcessingDTO;
import com.nagarro.microservices.model.OrderProcessModel;

@RestController
@RequestMapping("/order-process")
public class OrderProcessingController {
	
	@Autowired
	private OrderProcessingDTO orderProcessingDTO;
	
	@GetMapping("/{orderId}")
	public OrderProcessModel processOrder(@PathVariable long orderId) {
		return this.orderProcessingDTO.processOrder(orderId);
	}
	
	@GetMapping("/list")
	public List<OrderProcessModel> processOrderes(@RequestBody int[] orderIds) {
		return this.orderProcessingDTO.processOrderes(orderIds);
	}

}
