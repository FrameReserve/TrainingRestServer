package com.training.core.dao;

import com.training.core.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {

	/**
	 * 根据Id查询实体
	 */
	T getEntityById(final Class<T> cls, final Integer id);
	
	/**
	 * 新增实体
	 */
	void addEntity(final T entity);
	/**
	 * 更新实体
	 */
	void updateEntity(final T entity);
	
	/**
	 * 根据Id删除实体
	 */
	void deleteEntityById(final Class<T> cls, final Integer id);

	/**
	 * 查询全部
     */
	List<T> selectAll(Class<T> cls);
	
}
