package com.nagarro.microservices.service.proxy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nagarro.microservices.model.User;

public interface UserServiceProxy {
	
	@GetMapping("/user/user/{userId}")
	public User getUser(@PathVariable("userId") long userId);

}
