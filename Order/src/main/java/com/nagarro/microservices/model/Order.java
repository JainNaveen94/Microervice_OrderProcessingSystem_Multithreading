package com.nagarro.microservices.model;

public class Order {
	
	private long orderId;
	private double orderAmount;
	private String orderDate;
	private long userId;
	
	/* Default Constructor */
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	/* param Constructor */
	
	public Order(long orderId, double orderAmount, String orderDate, long userId) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.userId = userId;
	}


	/* getter/Setter */
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
