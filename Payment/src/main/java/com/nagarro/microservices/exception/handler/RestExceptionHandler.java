package com.nagarro.microservices.exception.handler;

import java.io.IOException;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nagarro.microservices.constants.PaymentConstant;
import com.nagarro.microservices.exception.custom.PaymentFailedException;
import com.nagarro.microservices.exception.custom.PaymentNotFoundException;
import com.nagarro.microservices.model.ErrorResponse;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(PaymentNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(PaymentFailedException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(IOException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(EntityNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(PaymentConstant.PAYMENT_NOT_FOUND);
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
