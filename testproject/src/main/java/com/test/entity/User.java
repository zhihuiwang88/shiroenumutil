package com.test.entity;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * User实体类
	 */
	private static final long serialVersionUID = 8941012353272388061L;

	private String userName;
	private Integer age;
	private String city;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + ", city=" + city + "]";
	}
	
	
	
}
