package com.nagarro.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.constants.PaymentConstant;
import com.nagarro.microservices.dto.PaymentDTO;
import com.nagarro.microservices.exception.custom.PaymentFailedException;
import com.nagarro.microservices.exception.custom.PaymentNotFoundException;
import com.nagarro.microservices.model.PaymentModel;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentDTO paymentDto;

	@GetMapping("/{userId}")
	public ResponseEntity<PaymentModel> getPayment(@PathVariable long userId) {
		PaymentModel payment = this.paymentDto.getPayment(userId);
		if (payment != null) {
			return new ResponseEntity<PaymentModel>(payment, HttpStatus.OK);
		} else {
			throw new PaymentNotFoundException(PaymentConstant.PAYMENT_NOT_FOUND);
		}

	}

	@GetMapping("/list")
	public ResponseEntity<List<PaymentModel>> getPayments() {
		return new ResponseEntity<List<PaymentModel>>(this.paymentDto.getPayments(), HttpStatus.OK);

	}

	@PutMapping("/{userId}")
	public ResponseEntity<PaymentModel> getUpdatedPayment(@RequestBody PaymentModel paymentModel,
			@PathVariable long userId) {
		PaymentModel updatedPayment = this.paymentDto.updatePayment(userId, paymentModel);
		if (updatedPayment != null) {
			return new ResponseEntity<PaymentModel>(updatedPayment, HttpStatus.OK);
		} else {
			throw new PaymentFailedException(PaymentConstant.PAYMENT_FAILED);
		}
	}
}
