package com.nagarro.microservices.Service;

import java.util.List;

import com.nagarro.microservices.model.User;

public interface UserService {

	User getUser(long userId);

	List<User> getUsers();

}
