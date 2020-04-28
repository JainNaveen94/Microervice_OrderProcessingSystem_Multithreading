package com.nagarro.microservices.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.microservices.model.Payment;
import com.nagarro.microservices.model.PaymentModel;
import com.nagarro.microservices.service.PaymentService;


@Component
public class PaymentDTOImpl implements PaymentDTO {
	
	@Autowired
	private PaymentService paymentService;

	@Override
	public PaymentModel getPayment(long userId) {
		return this.paymentToPaymentModel(this.paymentService.getPayment(userId));
	}

	@Override
	public List<PaymentModel> getPayments() {
		return this.paymentListToPaymentModelList(this.paymentService.getPayments());
	}

	@Override
	public boolean updatePayment(long userId, double amountToBeDeducted) {
		return this.paymentService.updatePayment(userId, amountToBeDeducted);
	}
	
	
	/******** Private Methods Used to Perform Mapping ********/
	
	// Convert the Payment Object to PaymentModel Object
	private PaymentModel paymentToPaymentModel(Payment payment) {
		return new PaymentModel(payment.getUserId(), payment.getAmount());
	}
	
	// Convert the List of Payment Object to List of PaymentModel Object
	private List<PaymentModel> paymentListToPaymentModelList(List<Payment> payments) {
		List<PaymentModel> paymentsModel = new ArrayList<PaymentModel>();
		
		for(Payment payment: payments) {
			paymentsModel.add(this.paymentToPaymentModel(payment));
		}
		
		return paymentsModel;
	}

}
