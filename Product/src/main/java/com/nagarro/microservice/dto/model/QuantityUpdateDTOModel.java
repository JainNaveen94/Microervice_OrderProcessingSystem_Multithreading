package com.nagarro.microservice.dto.model;

public class QuantityUpdateDTOModel {
	
	private boolean updateStatus;
	private String message;
	
	/* Default Constructor */
	public QuantityUpdateDTOModel() {
		// TODO Auto-generated constructor stub
	}

	/* Parameterized Constructor */
	public QuantityUpdateDTOModel(boolean updateStatus, String message) {
		super();
		this.updateStatus = updateStatus;
		this.message = message;
	}

	/* Getter / Setter */
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
