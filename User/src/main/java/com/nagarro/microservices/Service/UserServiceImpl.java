package com.nagarro.microservices.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservices.dao.UserDAO;
import com.nagarro.microservices.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;
	
	
	@Override
	public User getUser(long userId) {
		List<User> users = this.userDao.getUsers();
		if(users.size() > 0) {
			return this.getUserFromUsers(userId, users);
		} else {
			return null;
		}
	}


	// Method to Search the User in the User List Provided from the DB.
	private User getUserFromUsers(long userId, List<User> users) {
		for(User user: users) {
			if(user.getId() == userId) {
				return user;
			}
		}
		return null;
	}

}
