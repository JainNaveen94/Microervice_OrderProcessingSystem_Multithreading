package com.nagarro.microservices.dao;

import java.util.List;

import com.nagarro.microservices.model.Payment;

public interface PaymentDAO {

	Payment getPayment(long userId);

	List<Payment> getPayments();

	Payment updatePayment(Payment payment);

}
