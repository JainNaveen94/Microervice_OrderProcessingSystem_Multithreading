package com.nagarro.microservices.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.microservices.dto.repository.UserRepository;
import com.nagarro.microservices.model.User;

//import java.io.IOException;
//import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private UserRepository userRepository;

//	@Override
//	public List<User> getUsers() {
//		ObjectMapper mapper = new ObjectMapper();
//		TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
//		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/user.json");
//		try {
//			return mapper.readValue(inputStream,typeReference);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ArrayList<User>();
//	}
	
	@Override
	public List<User> getUsers() {
		try {
			return this.userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<User>();
	}
	
	

}
