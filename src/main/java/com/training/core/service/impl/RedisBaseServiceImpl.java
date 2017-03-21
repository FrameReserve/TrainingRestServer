package com.training.core.service.impl;

import javax.annotation.Resource;

import com.training.core.dao.RedisBaseDao;
import com.training.core.entity.BaseEntity;
import com.training.core.service.RedisBaseService;
import com.training.core.util.GenericeClassUtils;

public class RedisBaseServiceImpl<T extends BaseEntity> implements RedisBaseService<T> {

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);
		
	@Resource(name = "redisBaseDao")
	private RedisBaseDao<T> baseDao;
	
	@Override
	public T getEntityById(Integer id) {
		return baseDao.getEntityById(entityClass, id);
	}

	@Override
	public void addEntity(T entity) {
		baseDao.addEntity(entity);
	}

	@Override
	public void updateEntity(T entity) {
		baseDao.updateEntity(entity);
	}

	@Override
	public void deleteEntityById(Integer id) {
		baseDao.deleteEntityById(entityClass, id);
	}

}
