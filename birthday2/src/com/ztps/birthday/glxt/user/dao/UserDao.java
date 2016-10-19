package com.ztps.birthday.glxt.user.dao;

import java.util.List;

import com.ztps.birthday.core.dao.BaseDao;
import com.ztps.birthday.glxt.user.entity.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 根据帐号查询用户
	 * @param account 用户帐号
	 * @return 用户列表
	 */
	public List<User> findUserByAccount(String account);
	
	/**
	 * 根据帐号和密码查询用户
	 * @param account 账号
	 * @param password 密码
	 * @return
	 */
	public List<User> findUserByAccountAndPassword(String account,String password);
}
