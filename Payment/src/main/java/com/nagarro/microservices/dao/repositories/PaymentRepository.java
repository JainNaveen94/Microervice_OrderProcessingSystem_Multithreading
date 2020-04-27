package com.nagarro.microservices.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.microservices.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
