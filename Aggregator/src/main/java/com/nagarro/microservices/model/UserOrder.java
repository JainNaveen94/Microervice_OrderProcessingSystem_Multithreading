package com.nagarro.microservices.model;

import java.util.List;

public class UserOrder {
	
	private long id;
	private String name;
	private int age;
	private String email;
	private List<OrderDetail> orders;
	
	/* Default Constructor */
	
	public UserOrder() {
		// TODO Auto-generated constructor stub
	}
	
	/* Param Constructor */

	public UserOrder(long id, String name, int age, String email, List<OrderDetail> orders) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.orders = orders;
	}
	
	/* Getter/Setter */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<OrderDetail> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetail> orders) {
		this.orders = orders;
	}
}
