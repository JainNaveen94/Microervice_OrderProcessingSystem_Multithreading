package com.nagarro.microservice.exception.custom;

@SuppressWarnings("serial")
public class ProductNotAddedException extends RuntimeException {

	public ProductNotAddedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductNotAddedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductNotAddedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
