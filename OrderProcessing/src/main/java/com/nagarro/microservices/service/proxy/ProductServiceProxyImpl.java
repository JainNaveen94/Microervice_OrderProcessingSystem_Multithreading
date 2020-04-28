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

import com.nagarro.microservices.model.ProductModel;
import com.nagarro.microservices.model.QuantityUpdateDTOModel;

@Component
public class ProductServiceProxyImpl {

	@Value("${app.productServiceUrl}")
	private String productServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public ProductModel getProductById(long prodId) {
		try {
			ResponseEntity<ProductModel> productResponse = this.restTemplate.exchange(
					productServiceUrl + "/product/" + prodId, HttpMethod.GET, null,
					new ParameterizedTypeReference<ProductModel>() {
					});
			return productResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

	public List<ProductModel> getProductList() {
		try {
			ResponseEntity<List<ProductModel>> productListResponse = this.restTemplate.exchange(
					productServiceUrl + "/product/list", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<ProductModel>>() {
					});
			return productListResponse.getBody();
		} catch (Exception exception) {
			return new ArrayList<ProductModel>();
		}
	}

	public QuantityUpdateDTOModel updateProductQuantity(long prodId, int quantity) {
		try {
			ResponseEntity<QuantityUpdateDTOModel> quantityUpdateResponse = this.restTemplate.exchange(
					productServiceUrl + "/product/" + prodId + "/quantity/" + quantity, HttpMethod.PUT, null,
					new ParameterizedTypeReference<QuantityUpdateDTOModel>() {
					});
			return quantityUpdateResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

}
