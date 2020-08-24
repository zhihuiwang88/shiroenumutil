package com.test.entity;

import java.io.Serializable;

public class SysUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8279678878868184912L;
	private Integer id;
	private String userName;
	private String password;
	private String salt;
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	
}
