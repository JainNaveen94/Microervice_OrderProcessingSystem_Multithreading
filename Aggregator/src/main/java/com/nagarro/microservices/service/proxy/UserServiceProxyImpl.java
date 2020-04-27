package com.nagarro.microservices.service.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.constant.AggregatorConstant;
import com.nagarro.microservices.exception.custom.UserNotFoundException;
import com.nagarro.microservices.model.User;

@Component
//@RestController
public class UserServiceProxyImpl {
	
	@Value("${app.userServiceUrl}")
	private String userServiceUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	public User getUser(long userId) {
//		System.out.println("><><><" + userServiceUrl);
//		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<User> rateResponse = this.restTemplate.exchange(userServiceUrl + "user/" +userId,
					HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
					});
			return rateResponse.getBody();
		} catch (Exception exception) {
			throw new UserNotFoundException(AggregatorConstant.USER_NOT_FOUND + userId);
		}
	}

}
