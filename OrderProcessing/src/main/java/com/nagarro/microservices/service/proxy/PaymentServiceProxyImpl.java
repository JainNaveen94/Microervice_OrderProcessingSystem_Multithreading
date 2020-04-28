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

import com.nagarro.microservices.model.PaymentModel;
import com.nagarro.microservices.model.PaymentUpdateModel;

@Component
public class PaymentServiceProxyImpl {

	@Value("${app.paymentServiceUrl}")
	private String paymentServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public PaymentModel getPayment(long userId) {
		try {
			ResponseEntity<PaymentModel> paymentResponse = this.restTemplate.exchange(
					paymentServiceUrl + "/payment/" + userId, HttpMethod.GET, null,
					new ParameterizedTypeReference<PaymentModel>() {
					});
			return paymentResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

	public List<PaymentModel> getPayments() {
		try {
			ResponseEntity<List<PaymentModel>> paymentListResponse = this.restTemplate.exchange(
					paymentServiceUrl + "/payment/list", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<PaymentModel>>() {
					});
			return paymentListResponse.getBody();
		} catch (Exception exception) {
			return new ArrayList<PaymentModel>();
		}
	}

	public PaymentUpdateModel getUpdatedPayment(long userId, double amountToBeDeducted) {
		try {
			ResponseEntity<PaymentUpdateModel> paymentUpdateResponse = this.restTemplate.exchange(
					paymentServiceUrl + "/payment/" + userId + "/amount/" + amountToBeDeducted, HttpMethod.PUT, null,
					new ParameterizedTypeReference<PaymentUpdateModel>() {
					});
			return paymentUpdateResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

}
