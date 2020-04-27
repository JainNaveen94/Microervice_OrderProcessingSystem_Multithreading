package com.nagarro.microservice.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.microservice.dto.model.ProductDTOModel;
import com.nagarro.microservice.model.Product;
import com.nagarro.microservice.service.ProductService;

@Component
public class ProductDTOImpl implements ProductDTO {
	
	@Autowired
	private ProductService productService;
	
	/* All The Override Methos */

	@Override
	public ProductDTOModel addProduct(ProductDTOModel productDTOModel) {
		Product product = this.productService.addProduct(this.createProductFromProductDTOModel(productDTOModel));
		if(product != null) {
			return this.createProductDTOModelFromProduct(product);
		}
		return null;
	}
	
	@Override
	public ProductDTOModel getProductById(long prodId) {
		Product product = this.productService.getProductById(prodId);
		if(product != null) {
			return this.createProductDTOModelFromProduct(product);
		}
		return null;
	}

//	@Override
//	public ProductDTOModel getProductByProductName(String prodName) {
//		Product product = this.productService.getProductByProductName(prodName);
//		if(product != null) {
//			return this.createProductDTOModelFromProduct(product);
//		}
//		return null;
//	}

	@Override
	public List<ProductDTOModel> getProductList() {
		return this.createProductDTOModelsFromProducts(this.productService.getProductList());
	}

	@Override
	public Boolean deleteProductById(long prodId) {
		return this.productService.deleteProductById(prodId);
	}

	@Override
	public Boolean updateProductQuantity(long prodId, int quantity) {
		return this.productService.updateProductQuantity(prodId, quantity);
	}
	

	/* Private Methods Are Used Here For Internal Class Services */

	// Used to Create the Product From ProductDTOModel
	private Product createProductFromProductDTOModel(ProductDTOModel productDTOModel) {
		Product product = new Product();
		product.setProductName(productDTOModel.getProductName());
		product.setProductDescription(productDTOModel.getProductDescription());
		product.setProductPrice(productDTOModel.getProductPrice());
		product.setProductQuantity(productDTOModel.getProductQuantity());
		product.setProductCategory(productDTOModel.getProductCategory());
		return product;
	}

	// Used to Create the ProductDTOModel From Product
	private ProductDTOModel createProductDTOModelFromProduct(Product product) {
		return new ProductDTOModel(product.getId(), product.getProductName(), product.getProductDescription(),
				product.getProductPrice(), product.getProductQuantity(),product.getProductCategory());
	}
	
	// Used to Create the List Of ProductDTOModels
	private List<ProductDTOModel> createProductDTOModelsFromProducts(List<Product> products) {
		List<ProductDTOModel> productDtoModels= new ArrayList<ProductDTOModel>();
		for(Product productObj: products) {
			productDtoModels.add(this.createProductDTOModelFromProduct(productObj));
		}
		return productDtoModels;
	}

}
