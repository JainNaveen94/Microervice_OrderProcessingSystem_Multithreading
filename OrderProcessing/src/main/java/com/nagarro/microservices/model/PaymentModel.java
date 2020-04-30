package com.nagarro.microservices.model;

public class PaymentModel {
	
	private long userId;
	private double amount;
	
	/***** Default Constructor *****/
	
	public PaymentModel() {
		// TODO Auto-generated constructor stub
	}

	/***** Parameterized Constructor *****/
	
	public PaymentModel(long userId, double amount) {
		super();
		this.userId = userId;
		this.amount = amount;
	}
	
	
	/***** Getter-Setter *****/

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return String.format("\n User ID :: %d \n Amount Available :: %2f \n", this.getUserId(), this.getAmount());
	}

}
