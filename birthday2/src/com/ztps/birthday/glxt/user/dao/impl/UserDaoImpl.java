package com.ztps.birthday.glxt.user.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.ztps.birthday.core.dao.impl.BaseDaoImpl;
import com.ztps.birthday.glxt.user.dao.UserDao;
import com.ztps.birthday.glxt.user.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	@Override
	public List<User> findUserByAccount(String account) {
		Query query = getSession().createQuery("FROM User WHERE account = ?");
		query.setParameter(0, account);
		return query.list();
	}

	@Override
	public List<User> findUserByAccountAndPassword(String account,
			String password) {
		Query query = getSession().createQuery("FROM User WHERE account = ? AND password = ?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		return query.list();
	}
}
