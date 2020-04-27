package com.nagarro.microservices.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.microservices.constant.UserConstant;
import com.nagarro.microservices.dto.repository.UserRepository;
import com.nagarro.microservices.exception.custom.UserNotFoundException;
import com.nagarro.microservices.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		try {
			return this.userRepository.findAll();
		} catch (Exception e) {
			return new ArrayList<User>();
		}
	}
	
	@Override
	public User getUser(long userId) {
		try {
			return this.userRepository.getOne(userId);
		} catch (EntityNotFoundException e) {
			throw new UserNotFoundException(UserConstant.USER_NOT_FOUND + userId);
		}
	}
	
	

}
