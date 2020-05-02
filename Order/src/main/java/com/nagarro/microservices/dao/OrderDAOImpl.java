package com.nagarro.microservices.dao;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.microservices.constant.OrderConstant;
import com.nagarro.microservices.dao.repositories.OrderRepository;
import com.nagarro.microservices.exception.custom.OrderNotFoundException;
import com.nagarro.microservices.model.CumulativeOrderModel;
import com.nagarro.microservices.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	public Order getOrder(long orderId) {
		try {
			return this.orderRepository.getOne(orderId);
		} catch (EntityNotFoundException exception) {
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
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getTopNOrdersBasesdOnAmount(long n) {
		String hqlQuery = "select o1 from Order o1 where :n >= (select count(DISTINCT o2.orderAmount) from Order o2 where o2.orderAmount >= o1.orderAmount) order by o1.orderAmount DESC";
		Query query = entityManager.createQuery(hqlQuery);
		query.setParameter("n", n);
//		entityManager.getTransaction().begin();
		List<Order> orders = query.getResultList();
//		entityManager.getTransaction().commit();
		return orders;
	}

	@Override
	public Order getNthHighestOrderBasedOnAmount(int n) {
		String hqlQuery = "select o1 from Order o1 where :n = (select count(DISTINCT o2.orderAmount) from Order o2 where o2.orderAmount >= o1.orderAmount)";
		Query query = entityManager.createQuery(hqlQuery);
		query.setParameter("n", n);
		Order order = (Order) query.getResultList().get(0);
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CumulativeOrderModel> getCumulativeOrderValueOfEachUser() {
		String hqlQuery = "select o1.orderId, sum(o1.orderAmount), o1.userId from Order o1 group by o1.userId order by o1.orderAmount DESC";
		Query query = entityManager.createQuery(hqlQuery);
		List<CumulativeOrderModel> orders = (List<CumulativeOrderModel>) query.getResultList();
		return orders;
	}

}
