package com.nagarro.microservices.service.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.model.Order;

@Component
//@RestController
public class OrderServiceProxyImpl {

	@Value("${app.orderServiceUrl}")
	private String orderServiceUrl;

	@Autowired
	RestTemplate restTemplate;

	public List<Order> getOrderListOfUser(long userId) {
//		System.out.println("><><><" + orderServiceUrl);
//		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<List<Order>> rateResponse = this.restTemplate.exchange(
					orderServiceUrl + "order/list/" + userId, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Order>>() {
					});
			return rateResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

}
