package com.nagarro.microservices.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.microservices.Service.UserService;
import com.nagarro.microservices.model.User;
import com.nagarro.microservices.model.UserModel;

@Component
public class UserDTOImpl implements UserDTO {

	@Autowired
	private UserService userService;

	@Override
	public UserModel getUser(long userId) {
		return this.userToUserModelMapping(this.userService.getUser(userId));
	}
	
	@Override
	public List<UserModel> getUsers() {
		return this.userListToUserModelList(this.userService.getUsers());
	}

	// Mapper Function to Map User Object to UserModel Object
	private UserModel userToUserModelMapping(User user) {
		return new UserModel(user.getId(), user.getName(), user.getAge(), user.getEmail(), user.getMobile(),
				user.getAddress());
	}
	
	// Mapper Function to Map List of Users Object to List of UserModels Object
	private List<UserModel> userListToUserModelList(List<User> users) {
		List<UserModel> usersModel = new ArrayList<UserModel>();
		for(User user: users) {
			usersModel.add(this.userToUserModelMapping(user));
		}
		return usersModel;
	}

}
