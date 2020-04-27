package com.nagarro.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservices.dao.PaymentDAO;
import com.nagarro.microservices.model.Payment;


@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDAO paymentDao;

	@Override
	public Payment getPayment(long userId) {
		return this.paymentDao.getPayment(userId);
	}

	@Override
	public List<Payment> getPayments() {
		return this.paymentDao.getPayments();
	}

	@Override
	public Payment updatePayment(long userId, Payment payment) {
		// Getting the Payment from PaymentDataBase
		Payment updatedPayment = this.getPayment(userId);
		
		// Set the Payment Here
		updatedPayment.setAmount(updatedPayment.getAmount() - payment.getAmount());
		
		// Updated the Payment Here
		updatedPayment = this.paymentDao.updatePayment(updatedPayment);
		
		return updatedPayment;
	}

}
