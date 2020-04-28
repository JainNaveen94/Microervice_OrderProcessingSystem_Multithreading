package com.nagarro.microservices.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.microservices.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	// Fetch the List of Order Based on UserID
	List<Order> findOrdersByUserId(long userId);

}
