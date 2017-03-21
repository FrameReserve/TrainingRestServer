package com.training.core.dao;

import com.training.core.entity.BaseEntity;

public interface RedisBaseDao<T extends BaseEntity> {

	public T getEntityById(final Class<T> cls, final Integer id);
	
    public void addEntity(final T entity);

	public void updateEntity(T entity);

	public void deleteEntityById(final Class<T> cls, final Integer id);
	
}
