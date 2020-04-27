package com.nagarro.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservice.constants.ProductConstants;
import com.nagarro.microservice.dao.ProductDAO;
import com.nagarro.microservice.exception.custom.ProductNotFoundException;
import com.nagarro.microservice.exception.custom.ProductQuantityNotUpdatedException;
import com.nagarro.microservice.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDao;
	
	/* All The Override Methos */
	
	@Override
	public Product addProduct(Product product) {
		return this.productDao.addProduct(product);
	}

	@Override
	public Product getProductById(long prodId) {
		return this.productDao.getProductById(prodId);
	}

//	@Override
//	public Product getProductByProductName(String prodName) {
//		return this.productDao.getProductByProductName(prodName);
//	}

	@Override
	public List<Product> getProductList() {
		return this.productDao.getProductList();
	}

	@Override
	public Boolean deleteProductById(long prodId) {
		Product product = this.getProductById(prodId);
		if(product != null) {
			return this.productDao.deleteProduct(product);
		} else {
			throw new ProductNotFoundException(ProductConstants.PRODUCT_INCORRECT_ID);
		}
	}

	@Override
	public Boolean updateProductQuantity(long prodId, int quantity) {
		Product product = this.getProductById(prodId);
		if(product != null) {
			if(product.getProductQuantity() > quantity) {
				int new_quantity = product.getProductQuantity() - quantity;
				product.setProductQuantity(new_quantity);
				product = this.addProduct(product);
				if(product.getProductQuantity() == new_quantity) {
					return true;
				} else {
					return false;
				}
			} else {
				throw new ProductQuantityNotUpdatedException(ProductConstants.HIGER_QUANTITY);
			}
		} else {
			throw new ProductNotFoundException(ProductConstants.PRODUCT_INCORRECT_ID);
		}
	}

}
