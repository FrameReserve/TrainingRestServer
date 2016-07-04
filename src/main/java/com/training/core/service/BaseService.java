package com.training.core.service;

import com.training.core.entity.BaseEntity;

public interface BaseService<T extends BaseEntity> {

	/**
	 * 根据Id查询实体
	 */
	T getEntityById(final Integer id);
	
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
	void deleteEntityById(final Integer id);

}
