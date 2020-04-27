package com.nagarro.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.constant.UserConstant;
import com.nagarro.microservices.dto.UserDTO;
import com.nagarro.microservices.exception.custom.UserNotFoundException;
import com.nagarro.microservices.model.UserModel;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDTO userDTO;

	@GetMapping("/{userId}")
	public ResponseEntity<UserModel> getUser(@PathVariable long userId) {
		UserModel user = this.userDTO.getUser(userId);
		if (user != null) {
			return new ResponseEntity<UserModel>(user, HttpStatus.OK);
		} else {
			throw new UserNotFoundException(UserConstant.USER_NOT_FOUND_EXCEPTION + userId);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<UserModel>> getUsers() {
		List<UserModel> users = this.userDTO.getUsers();
		return new ResponseEntity<List<UserModel>>(users, HttpStatus.OK);
	}

}
