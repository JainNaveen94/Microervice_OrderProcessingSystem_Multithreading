package com.nagarro.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservices.constants.PaymentConstant;
import com.nagarro.microservices.dao.PaymentDAO;
import com.nagarro.microservices.exception.custom.PaymentFailedException;
import com.nagarro.microservices.exception.custom.PaymentNotFoundException;
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
	public boolean updatePayment(long userId, double amountToBeUpdated) {
		// Getting the Payment from PaymentDataBase
		Payment updatedPayment = this.getPayment(userId);

		if (updatedPayment != null) {
			if (updatedPayment.getAmount() > amountToBeUpdated) {
				// Updated Amount
				double updatedAmount = updatedPayment.getAmount() - amountToBeUpdated;
				// Set the Payment Here
				updatedPayment.setAmount(updatedAmount);
				// Updated the Payment Here
				updatedPayment = this.paymentDao.updatePayment(updatedPayment);
				//Check for updated payment
				if (updatedPayment.getAmount() == updatedAmount) {
					return true;
				} else {
					return false;
				}
			} else {
				throw new PaymentFailedException(PaymentConstant.PAYMENT_FAILED_INSUFFICENT);
			}
		} else {
			throw new PaymentNotFoundException(PaymentConstant.PAYMENT_NOT_FOUND);
		}
	}

}
