package com.ztps.birthday.glxt.customer.entity;

import java.io.Serializable;
import java.util.Date;

import com.ztps.birthday.glxt.user.entity.User;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name; 	//客户名称
	private boolean gender;	//客户性别
	private String mobile;	//客户手机号
	private Date birthday;	//生日
	private String address;	//客户地址
	private User user;		//客户登录类
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
