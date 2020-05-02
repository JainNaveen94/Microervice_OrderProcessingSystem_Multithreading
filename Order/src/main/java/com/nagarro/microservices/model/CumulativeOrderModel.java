package com.nagarro.microservices.model;

public class CumulativeOrderModel {

	private long orderId;
	private long userId;
	private double totalAmount;

	/****** Default Constructor ******/

	public CumulativeOrderModel() {
		// TODO Auto-generated constructor stub
	}

	/****** Param Contructor ******/

	public CumulativeOrderModel(long orderId, long userId, double totalAmount) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
	}

	/****** Getter-Setter ******/

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return String.format("\n Order ID : %d \n User ID : %d \n Total Amount : %2f \n", this.getOrderId(),
				this.getUserId(), this.getTotalAmount());
	}

}
