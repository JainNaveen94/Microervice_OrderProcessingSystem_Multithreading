package com.nagarro.microservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.microservice.model.Product;
import com.nagarro.microservice.repository.ProductRepository;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Product getProductById(long prodId) {
		return this.productRepository.getOne(prodId);
	}

//	@Override
//	public Product getProductByProductName(String prodName) {
//		return this.productRepository.findByProduct_name(prodName);
//	}

	@Override
	public List<Product> getProductList() {
		return this.productRepository.findAll();
	}

	@Override
	public Boolean deleteProduct(Product product) {
		this.productRepository.delete(product);
		return true;
	}

}
