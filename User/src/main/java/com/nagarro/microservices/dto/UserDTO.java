package com.nagarro.microservices.dto;

import java.util.List;

import com.nagarro.microservices.model.UserModel;

public interface UserDTO {

	UserModel getUser(long userId);

	List<UserModel> getUsers();

}
