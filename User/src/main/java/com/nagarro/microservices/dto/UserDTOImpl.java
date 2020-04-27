package com.nagarro.microservices.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.microservices.Service.UserService;
import com.nagarro.microservices.model.User;


@Component
public class UserDTOImpl implements UserDTO {
	
	@Autowired
	private UserService userService;

	@Override
	public User getUser(long userId) {
		return this.userService.getUser(userId);
	}

}
