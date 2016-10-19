package com.ztps.birthday.glxt.user.entity;

import java.io.Serializable;

import com.ztps.birthday.glxt.customer.entity.Customer;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;			//编号
	private String account;		//账号，默认是手机号
	private String password;	//密码
	private String power;		//权限
	private String state;		//状态
	private Customer customer;  //客户类
	
	//用户状态
	public static String USER_STATE_VALID = "1";	//有效
	public static String USER_STATE_INVALID = "0";	//无效
	
	//用户权限
	public static String USER_POWER_ADMID = "a"; 	//商家
	public static String USER_POWER_INADMID = "c";	//客户
	
	public User() {
	}
	
	public User(String account, String password, String power, String state) {
		this.account = account;
		this.password = password;
		this.power = power;
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}

