package com.nagarro.microservices.dao;

import java.util.List;

import com.nagarro.microservices.model.User;

public interface UserDAO {

	List<User> getUsers();

}
