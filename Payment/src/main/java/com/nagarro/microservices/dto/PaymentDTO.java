package com.nagarro.microservices.dto;

import java.util.List;

import com.nagarro.microservices.model.PaymentModel;

public interface PaymentDTO {

	PaymentModel getPayment(long userId);

	List<PaymentModel> getPayments();

	PaymentModel updatePayment(long userId, PaymentModel paymentModel);

}
