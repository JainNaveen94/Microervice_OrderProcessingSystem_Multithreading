package com.nagarro.microservices.service;

import java.util.List;

import com.nagarro.microservices.model.Payment;

public interface PaymentService {

	Payment getPayment(long userId);

	List<Payment> getPayments();

	Payment updatePayment(long userId, Payment payment);

}
