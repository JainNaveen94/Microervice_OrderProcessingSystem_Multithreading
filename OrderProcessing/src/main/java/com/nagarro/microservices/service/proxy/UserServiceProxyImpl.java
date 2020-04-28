package com.nagarro.microservices.service.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.model.UserModel;

@Component
public class UserServiceProxyImpl {

	@Value("${app.userServiceUrl}")
	private String userServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public UserModel getUser(long userId) {
		try {
			ResponseEntity<UserModel> userResponse = this.restTemplate.exchange(userServiceUrl + "/user/" + userId,
					HttpMethod.GET, null, new ParameterizedTypeReference<UserModel>() {
					});
			return userResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

	public List<UserModel> getUsers() {
		try {
			ResponseEntity<List<UserModel>> userListResponse = this.restTemplate.exchange(userServiceUrl + "/user/list",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<UserModel>>() {
					});
			return userListResponse.getBody();
		} catch (Exception exception) {
			return new ArrayList<UserModel>();
		}
	}
}
