package com.nagarro.microservices.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservices.dao.OrderDAO;
import com.nagarro.microservices.model.CumulativeOrderModel;
import com.nagarro.microservices.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;

	@Override
	public Order getOrder(long orderId) {
		return this.orderDao.getOrder(orderId);
	}

	@Override
	public List<Order> getOrders() {
		return this.orderDao.getOrders();
	}

	@Override
	public List<Order> getOrdersOfuser(long userId) {
		return this.orderDao.getOrdersOfUser(userId);
	}

	@Override
	public List<Order> getTopNOrdersBasesdOnAmount(long n) {
		return this.orderDao.getTopNOrdersBasesdOnAmount(n);
	}

	@Override
	public Order getNthHighestOrderBasedOnAmount(int n) {
		return this.orderDao.getNthHighestOrderBasedOnAmount(n);
	}

	@Override
	public List<CumulativeOrderModel> getCumulativeOrderValueOfEachUser() {
		return this.orderDao.getCumulativeOrderValueOfEachUser();
	}

	/***** --------------- Private Method ---------------- *****/

	// Search All the Orders of Specific User From Order List through UserId
//	private List<Order> getOrdersOfuserFromUserId(long userId, List<Order> orders) {
//		List<Order> userOrders = new ArrayList<Order>();
//		for (Order order : orders) {
//			if (order.getUserId() == userId) {
//				userOrders.add(order);
//			}
//		}
//		return userOrders;
//	}

	// Search the Specific Order by OrderId from the Order List
//	private Order getOrderFromOrderID(long orderId, List<Order> orders) {
//		for (Order order : orders) {
//			if (order.getOrderId() == orderId) {
//				return order;
//			}
//		}
//		return null;
//	}

}
