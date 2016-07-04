package com.training.core.service.impl;

import javax.annotation.Resource;

import com.training.core.dao.BaseDao;
import com.training.core.entity.BaseEntity;
import com.training.core.service.BaseService;
import com.training.core.util.GenericeClassUtils;
import tk.mybatis.mapper.common.Mapper;

public class MyBatisBaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);
	
	@Resource(name = "myBatisBaseDao")
	private BaseDao<T> baseDao;

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
