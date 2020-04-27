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
		return this.userDao.getUser(userId);
	}

	@Override
	public List<User> getUsers() {
		return this.userDao.getUsers();
	}

}
