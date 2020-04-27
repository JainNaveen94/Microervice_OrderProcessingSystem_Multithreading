package com.nagarro.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservice.constants.ProductConstants;
import com.nagarro.microservice.dto.ProductDTO;
import com.nagarro.microservice.dto.model.ProductDTOModel;
import com.nagarro.microservice.dto.model.QuantityUpdateDTOModel;
import com.nagarro.microservice.exception.custom.ProductNotAddedException;
import com.nagarro.microservice.exception.custom.ProductNotDeletedException;
import com.nagarro.microservice.exception.custom.ProductNotFoundException;

@RestController
@RequestMapping("/product-service")
public class ProductController {
	
	@Autowired
	private ProductDTO productDto;
	
	@PostMapping("/product")
	public ResponseEntity<ProductDTOModel> addProduct(@RequestBody ProductDTOModel productDTOModel) {
		ProductDTOModel productDtoModel = this.productDto.addProduct(productDTOModel);
		if(productDtoModel != null) {
			return new ResponseEntity<ProductDTOModel>(productDtoModel, HttpStatus.OK);
		} else {
			throw new ProductNotAddedException(ProductConstants.PRODUCT_NOT_ADDED);
		}
	}
	
	@GetMapping("/product/product-id/{prodId}")
	public ResponseEntity<ProductDTOModel> getProductById(@PathVariable long prodId) {
		ProductDTOModel productDtoModel = this.productDto.getProductById(prodId);
		if(productDtoModel != null) {
			return new ResponseEntity<ProductDTOModel>(productDtoModel, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException(ProductConstants.PRODUCT_INCORRECT_ID + prodId);
		}
	}
	
//	@GetMapping("/product/product-name/{prodName}")
//	public ResponseEntity<ProductDTOModel> getProductByProductName(@PathVariable String prodName) {
//		ProductDTOModel productDtoModel = this.productDto.getProductByProductName(prodName);
//		if(productDtoModel != null) {
//			return new ResponseEntity<ProductDTOModel>(productDtoModel, HttpStatus.OK);
//		} else {
//			throw new ProductNotFoundException(ProductConstants.PRODUCT_NOT_FOUND);
//		}
//	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDTOModel>> getProductList() {
		List<ProductDTOModel> products = this.productDto.getProductList();
		return new ResponseEntity<List<ProductDTOModel>>(products, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/product-id/{prodId}")
	public ResponseEntity<String> deleteProductById(@PathVariable long prodId) {
		Boolean result = this.productDto.deleteProductById(prodId);
		if(result) {
			return new ResponseEntity<String>(ProductConstants.PRODUCT_DELETED_SUCCESS + prodId, HttpStatus.OK);
		} else {
			throw new ProductNotDeletedException(ProductConstants.PRODUCT_DELETED_FAILER + prodId);
		}
	}
	
	@PutMapping("/product/update-quantity/product-id/{prodId}/quantity/{quantity}")
	public ResponseEntity<QuantityUpdateDTOModel> updateProductQuantity(@PathVariable long prodId, @PathVariable int quantity) {
		Boolean result = this.productDto.updateProductQuantity(prodId, quantity);
		QuantityUpdateDTOModel response;
		if(result) {
			response = new QuantityUpdateDTOModel(result, ProductConstants.QUANTITY_UPDATED_SUCCESS);
			return new ResponseEntity<QuantityUpdateDTOModel>(response, HttpStatus.OK);
		} else {
			response = new QuantityUpdateDTOModel(result, ProductConstants.QUANTITY_UPDATED_FAILER);
			return new ResponseEntity<QuantityUpdateDTOModel>(response, HttpStatus.OK);
		}
	}

}
