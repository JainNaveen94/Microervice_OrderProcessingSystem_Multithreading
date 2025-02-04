package com.nagarro.microservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderProduct")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "productId")
	private long productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "productDescription")
	private String productDescription;

	@Column(name = "productPrice")
	private float productPrice;

	@Column(name = "productQuantity")
	private int productQuantity;

	@Column(name = "productCategory")
	private String productCategory;

	/***** Default Constructor *****/

	public Product() {
		// TODO Auto-generated constructor stub
	}

	/***** Param Constructor *****/

	public Product(long id, long productId, String productName, String productDescription, float productPrice,
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
