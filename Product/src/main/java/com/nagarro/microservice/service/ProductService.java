package com.nagarro.microservice.service;

import java.util.List;

import com.nagarro.microservice.model.Product;

public interface ProductService {

	Product addProduct(Product product);

	Product getProductById(long prodId);

//	Product getProductByProductName(String prodName);

	List<Product> getProductList();

	Boolean deleteProductById(long prodId);

	Boolean updateProductQuantity(long prodId, int quantity);

}
