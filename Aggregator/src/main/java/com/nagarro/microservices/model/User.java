package com.nagarro.microservices.model;

public class User {
	
	private long id;
	private String name;
	private int age;
	private String email;
	
	/* Default Constructor */
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	/* Param Constructor */
	
	public User(long id, String name, int age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	/* Getter/ Setter */

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
	
}
