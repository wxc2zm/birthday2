package com.ztps.birthday.glxt.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ztps.birthday.core.service.impl.BaseServiceImpl;
import com.ztps.birthday.glxt.user.dao.UserDao;
import com.ztps.birthday.glxt.user.entity.User;
import com.ztps.birthday.glxt.user.service.UserService;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	private UserDao userDao;
	
	@Resource
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}
	
	@Override
	public List<User> findUserByAccount(String account) {
		return userDao.findUserByAccount(account);
	}

	@Override
	public List<User> findUserByAccountAndPassword(String account,
			String password) {
		return userDao.findUserByAccountAndPassword(account, password);
	}
}
