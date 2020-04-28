package com.nagarro.microservices.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.microservices.constants.PaymentConstant;
import com.nagarro.microservices.dao.repositories.PaymentRepository;
import com.nagarro.microservices.exception.custom.PaymentFailedException;
import com.nagarro.microservices.exception.custom.PaymentNotFoundException;
import com.nagarro.microservices.model.Payment;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment getPayment(long userId) {
		try {
			return this.paymentRepository.getOne(userId);
		} catch (EntityNotFoundException exception) {
			throw new PaymentNotFoundException(PaymentConstant.PAYMENT_NOT_FOUND);
		}
	}

	@Override
	public List<Payment> getPayments() {
		try {
			return this.paymentRepository.findAll();
		} catch (Exception e) {
			throw new PaymentNotFoundException(PaymentConstant.PAYMENT_NOT_FOUND);
		}
	}

	@Override
	public Payment updatePayment(Payment payment) {
		try {
			return this.paymentRepository.save(payment);
		} catch (IllegalArgumentException exception) {
			throw new PaymentFailedException(PaymentConstant.PAYMENT_FAILED_INSUFFICENT);
		}
	}
	
}
