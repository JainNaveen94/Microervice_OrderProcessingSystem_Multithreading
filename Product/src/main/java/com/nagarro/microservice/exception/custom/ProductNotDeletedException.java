package com.nagarro.microservice.exception.custom;

@SuppressWarnings("serial")
public class ProductNotDeletedException extends RuntimeException {

	public ProductNotDeletedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductNotDeletedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductNotDeletedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
