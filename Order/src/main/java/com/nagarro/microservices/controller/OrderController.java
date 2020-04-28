package com.nagarro.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.constant.OrderConstant;
import com.nagarro.microservices.dto.OrderDTO;
import com.nagarro.microservices.exception.custom.OrderNotFoundException;
import com.nagarro.microservices.model.OrderModel;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderDTO orderDto;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderModel> getOrder(@PathVariable long orderId) {
		OrderModel order = this.orderDto.getOrder(orderId);
		if(order != null) {
			return new ResponseEntity<OrderModel>(order, HttpStatus.OK);
		} else {
			throw new OrderNotFoundException(OrderConstant.ORDER_NOT_FOUND + orderId);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<OrderModel>> getOrders() {
		List<OrderModel> orders = this.orderDto.getOrders();
		return new ResponseEntity<List<OrderModel>>(orders, HttpStatus.OK);
	}
	
	@GetMapping("/list/{userId}")
	public ResponseEntity<List<OrderModel>> getOrdersOfUser(@PathVariable long userId) {
		List<OrderModel> orders = this.orderDto.getOrdersOfUser(userId);
		return new ResponseEntity<List<OrderModel>>(orders, HttpStatus.OK);
	}

}
