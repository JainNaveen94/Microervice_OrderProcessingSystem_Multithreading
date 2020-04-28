package com.nagarro.microservices.model;

import java.util.List;

public class OrderModel {

	private long orderId;
	private double amount;
	private long userId;
	private List<ProductOrderedModel> products;

	/***** Default Constructor *****/

	public OrderModel() {
		// TODO Auto-generated constructor stub
	}

	/***** Parameterized Constructor *****/

	public OrderModel(long orderId, double amount, long userId, List<ProductOrderedModel> products) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.userId = userId;
		this.products = products;
	}

	/***** Getter-Setter *****/

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<ProductOrderedModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductOrderedModel> products) {
		this.products = products;
	}

}
