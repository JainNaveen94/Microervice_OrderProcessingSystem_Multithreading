package com.nagarro.microservices.model;

public class UserModel {

	private long id;
	private String name;
	private int age;
	private String email;
	private String mobile;
	private String address;

	/**** Default Constructor *****/

	public UserModel() {
		// TODO Auto-generated constructor stub
	}

	/**** Parameterized Constructor *****/

	public UserModel(long id, String name, int age, String email, String mobile, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	/**** Getter-Setter *****/

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Overriding toString() method

	@Override
	public String toString() {
		return String.format(
				"\n User ID :: %d \n User Name :: %s \n User Age :: %d \n "
						+ "User Email :: %s \n User Mobile :: %s \n User Address :: %s \n",
				this.getId(), this.getName(), this.getAge(), this.getEmail(), this.getMobile(), this.getAddress());
	}

}
