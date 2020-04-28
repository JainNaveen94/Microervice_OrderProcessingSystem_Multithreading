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

import com.nagarro.microservices.model.OrderModel;

@Component
public class OrderServiceProxyImpl {

	@Value("${app.orderServiceUrl}")
	private String orderServiceUrl;

	@Autowired
	RestTemplate restTemplate;

	public List<OrderModel> getOrderListOfUser(long userId) {
		try {
			ResponseEntity<List<OrderModel>> orderListResponse = this.restTemplate.exchange(
					orderServiceUrl + "/order/list/" + userId, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<OrderModel>>() {
					});
			return orderListResponse.getBody();
		} catch (Exception exception) {
			return new ArrayList<OrderModel>();
		}
	}

	public OrderModel getOrder(long orderId) {
		try {
			ResponseEntity<OrderModel> orderResponse = this.restTemplate.exchange(orderServiceUrl + "/order/" + orderId,
					HttpMethod.GET, null, new ParameterizedTypeReference<OrderModel>() {
					});
			return orderResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

}
