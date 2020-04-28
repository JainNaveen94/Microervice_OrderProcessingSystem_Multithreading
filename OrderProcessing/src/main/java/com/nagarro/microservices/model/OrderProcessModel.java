package com.nagarro.microservices.model;

public class OrderProcessModel {

	private long orderId;
	private long userId;
	private String userName;
	private double orderAmount;
	private boolean orderStatus;
	private String Message;

	/***** Default Constructor *****/

	public OrderProcessModel() {
		// TODO Auto-generated constructor stub
	}

	/***** Param Constructor *****/

	public OrderProcessModel(long orderId, long userId, String userName, double orderAmount, boolean orderStatus,
			String message) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.userName = userName;
		this.orderAmount = orderAmount;
		this.orderStatus = orderStatus;
		Message = message;
	}

	/***** Getter-Setter *****/

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public boolean getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return String.format(
				"\n Order ID : %d \n User ID : %d \n User Name : %s \n Order Amount : %d \n Order Status : %b \n Message : %s \n",
				this.getOrderId(), this.getUserId(), this.getUserName(), this.getOrderAmount(), this.getOrderStatus(),
				this.getMessage());
	}

}
