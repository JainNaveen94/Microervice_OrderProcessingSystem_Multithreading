package com.nagarro.microservices.service.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.model.ProductDTOModel;
import com.nagarro.microservices.model.QuantityUpdateDTOModel;

@Component
public class ProductServiceProxyImpl {

	@Value("${app.productServiceUrl}")
	private String productServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public ProductDTOModel getProductById(long prodId) {
		try {
			ResponseEntity<ProductDTOModel> productResponse = this.restTemplate.exchange(
					productServiceUrl + "product/" + prodId, HttpMethod.GET, null,
					new ParameterizedTypeReference<ProductDTOModel>() {
					});
			return productResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

	public List<ProductDTOModel> getProductList() {
		try {
			ResponseEntity<List<ProductDTOModel>> productListResponse = this.restTemplate.exchange(
					productServiceUrl + "product/list", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<ProductDTOModel>>() {
					});
			return productListResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

	public QuantityUpdateDTOModel updateProductQuantity(long prodId, int quantity) {
		try {
			ResponseEntity<QuantityUpdateDTOModel> quantityUpdateResponse = this.restTemplate.exchange(
					productServiceUrl + "product/" + prodId + "/quantity/" + quantity, HttpMethod.PUT, null,
					new ParameterizedTypeReference<QuantityUpdateDTOModel>() {
					});
			return quantityUpdateResponse.getBody();
		} catch (Exception exception) {
			return null;
		}
	}

}
