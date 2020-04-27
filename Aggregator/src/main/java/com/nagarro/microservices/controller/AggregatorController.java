package com.nagarro.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.constant.AggregatorConstant;
import com.nagarro.microservices.dto.AggregatorDTO;
import com.nagarro.microservices.exception.custom.UserNotFoundException;
import com.nagarro.microservices.model.UserOrder;

@RestController
@RequestMapping("/order")
public class AggregatorController {
	
	@Autowired
	private AggregatorDTO aggregatorDto;
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserOrder> getUserOrders(@PathVariable long userId) {
		UserOrder userOrders = this.aggregatorDto.getUserOrders(userId);
		if(userOrders != null) {
			return new ResponseEntity<UserOrder>(userOrders, HttpStatus.OK);
		} else {
			throw new UserNotFoundException(AggregatorConstant.USER_NOT_FOUND + userId);
		}
	}

}
