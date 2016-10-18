package com.ztps.birthday.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ztps.birthday.core.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	Class<T> clazz;
	
	/**
	 * 通过反射得到类的类名
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(Serializable id) {
		getHibernateTemplate().delete(findObjectById(id));
	}

	@Override
	public T findObjectById(Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findObjects() {
		Query query = getSession().createQuery("FROM " + clazz.getSimpleName());
		return query.list();
	}

	@Override
	public List<T> findObjects(String hql, List<Object> parameters) {
		Query query = getSession().createQuery(hql);
		if (parameters != null) {
			for (int i = 0; i < parameters.size(); i++) {
				query.setParameter(i, parameters.get(i));
			}
		}
		return query.list();
	}

}
