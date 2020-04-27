package com.nagarro.microservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.microservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
//	public Product findByProduct_name(String product_name);
}
