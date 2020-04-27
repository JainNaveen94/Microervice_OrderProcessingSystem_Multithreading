package com.nagarro.microservices.model;

public class OrderDetail {
	
	private long orderId;
	private double orderAmount;
	private String orderDate;
	
	/* Default Constructor */
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	/* Param Constructor */
	
	public OrderDetail(long orderId, double orderAmount, String orderDate) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}
	
	/* Getter/Setter */

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
	
	
}
