package com.ztps.birthday.core.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	//新增
	public void save(T entity);
	//更新
	public void update(T entity);
	//根据id删除
	public void delete(Serializable id);
	//根据id查找
	public T findObjectById(Serializable id);
	//查找列表
	public List<T> findObjects();
	//条件查询实体列表
	@Deprecated
	public List<T> findObjects(String hql, List<Object> parameters);
}
