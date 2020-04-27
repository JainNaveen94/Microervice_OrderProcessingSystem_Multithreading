package com.nagarro.microservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private long userId;
	
	@Column(name="amount")
	private double amount;
	
	/***** Default Constructor *****/
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	/***** Parameterized Constructor *****/
	
	public Payment(long userId, double amount) {
		super();
		this.userId = userId;
		this.amount = amount;
	}
	
	
	/***** Getter-Setter *****/

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
