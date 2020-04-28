package com.nagarro.microservices.model;

public class PaymentUpdateModel {
	
	private boolean updateStatus;
	private String message;
	
	/***** Default Constructor *****/
	public PaymentUpdateModel() {
		// TODO Auto-generated constructor stub
	}

	/***** Parameterized Constructor *****/
	public PaymentUpdateModel(boolean updateStatus, String message) {
		super();
		this.updateStatus = updateStatus;
		this.message = message;
	}

	/***** Getter / Setter *****/
	public boolean isUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(boolean updateStatus) {
		this.updateStatus = updateStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
