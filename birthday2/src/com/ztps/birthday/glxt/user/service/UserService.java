package com.ztps.birthday.glxt.user.service;

import java.util.List;

import com.ztps.birthday.core.service.BaseService;
import com.ztps.birthday.glxt.user.entity.User;

public interface UserService extends BaseService<User> {
	/**
	 * 根据帐号查询用户
	 * @param account 用户帐号
	 * @return 用户列表
	 */
	public List<User> findUserByAccount(String account);
	
	public List<User> findUserByAccountAndPassword(String account, String password);
}
