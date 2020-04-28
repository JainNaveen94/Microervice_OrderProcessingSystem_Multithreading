package com.nagarro.microservices.dao;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nagarro.microservices.constant.OrderConstant;
import com.nagarro.microservices.dao.repositories.OrderRepository;
import com.nagarro.microservices.exception.custom.OrderNotFoundException;
import com.nagarro.microservices.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order getOrder(long orderId) {
		try {
			return this.orderRepository.getOne(orderId);
		} catch(EntityNotFoundException exception) {
			throw new OrderNotFoundException(OrderConstant.ORDER_NOT_FOUND_EXCEPTION);
		}
	}

	@Override
	public List<Order> getOrders() {
		return this.orderRepository.findAll();
	}
	
	
	@Override
	public List<Order> getOrdersOfUser(long userId) {
		return this.orderRepository.findOrdersByUserId(userId);
//		return new ArrayList<Order>();
	}

}
