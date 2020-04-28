package com.nagarro.microservices.model;


public class ProductOrderedModel {

	private long id;
	private long productId;
	private String productName;
	private String productDescription;
	private float productPrice;
	private int productQuantity;
	private String productCategory;

	/***** Default Constructor *****/

	public ProductOrderedModel() {
		// TODO Auto-generated constructor stub
	}

	/***** Param Constructor *****/

	public ProductOrderedModel(long id, long productId, String productName, String productDescription, float productPrice,
			int productQuantity, String productCategory) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productCategory = productCategory;
	}

	/***** Getter-Setter *****/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

}
