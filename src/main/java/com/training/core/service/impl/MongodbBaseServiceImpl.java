package com.training.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.training.core.dao.MongodbBaseDao;
import com.training.core.dto.CriteriaDto;
import com.training.core.dto.FlexiPageDto;
import com.training.core.entity.MongodbBaseEntity;
import com.training.core.service.MongodbBaseService;
import com.training.core.util.GenericeClassUtils;

public class MongodbBaseServiceImpl<T extends MongodbBaseEntity> implements MongodbBaseService<T> {

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);

	@Resource(name = "mongodbBaseDao")
	private MongodbBaseDao<T> baseDao;
	
	@Override
	public T getEntityById(String id) {
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
	public void deleteEntityById(String id) {
		baseDao.deleteEntityById(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		return baseDao.findAll(entityClass);
	}

	@Override
	public List<T> findByLike(CriteriaDto<T> criteriaDto) {
		return baseDao.findByLike(criteriaDto);
	}

	@Override
	public List<T> findByPage(CriteriaDto<T> criteriaDto, FlexiPageDto flexiPageDto) {
		return baseDao.findByPage(criteriaDto, flexiPageDto);
	}

	@Override
	public long findRowCount(CriteriaDto<T> criteriaDto) {
		return baseDao.findRowCount(criteriaDto);
	}

}
