package com.nagarro.microservices.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private long orderId;

	@Column(name = "orderAmount")
	private double orderAmount;

	@Column(name = "userId")
	private long userId;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private List<Product> products;

	/***** Default Constructor *****/

	public Order() {
		// TODO Auto-generated constructor stub
	}

	/***** Parameterized Constructor *****/

	public Order(long orderId, double orderAmount, long userId, List<Product> products) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.userId = userId;
		this.products = products;
	}
	
	/***** Getter-Setter *****/

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
