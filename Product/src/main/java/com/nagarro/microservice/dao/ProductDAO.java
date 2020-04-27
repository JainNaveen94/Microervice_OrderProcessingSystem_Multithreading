package com.nagarro.microservice.dao;

import java.util.List;

import com.nagarro.microservice.model.Product;

public interface ProductDAO {

	Product addProduct(Product product);

	Product getProductById(long prodId);

//	Product getProductByProductName(String prodName);

	List<Product> getProductList();

	Boolean deleteProduct(Product product);

}
