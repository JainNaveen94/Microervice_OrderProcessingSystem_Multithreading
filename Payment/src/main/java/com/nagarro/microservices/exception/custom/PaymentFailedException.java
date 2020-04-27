package com.nagarro.microservices.exception.custom;

public class PaymentFailedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentFailedException() {
		System.out.println();
	}

	public PaymentFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentFailedException(String message) {
		super(message);
	}

	public PaymentFailedException(Throwable cause) {
		super(cause);
	}

}
