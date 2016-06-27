package com.training.core.dao;

import com.training.core.entity.BaseEntity;

public interface BaseDao<T extends BaseEntity> {

	/**
	 * 根据Id查询实体
	 */
	public T getEntityById(final Class<T> cls, final Integer id);
	
	/**
	 * 新增实体
	 */
	public void addEntity(final T entity);
	/**
	 * 更新实体
	 */
	public void updateEntity(final T entity);
	
	/**
	 * 根据Id删除实体
	 */
	public void deleteEntityById(final Class<T> cls, final Integer id);
	
}
