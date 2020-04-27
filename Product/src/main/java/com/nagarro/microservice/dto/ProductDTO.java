package com.nagarro.microservice.dto;

import java.util.List;

import com.nagarro.microservice.dto.model.ProductDTOModel;

public interface ProductDTO {

	ProductDTOModel addProduct(ProductDTOModel productDTOModel);

	ProductDTOModel getProductById(long prodId);

//	ProductDTOModel getProductByProductName(String prodName);

	List<ProductDTOModel> getProductList();

	Boolean deleteProductById(long prodId);

	Boolean updateProductQuantity(long prodId, int quantity);

}
