package com.training.core.dao.impl;

import com.training.core.dao.BaseDao;
import com.training.core.entity.BaseEntity;

import java.util.List;

public class JpaBaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

	@Override
	public T getEntityById(Class<T> cls, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEntity(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEntity(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntityById(Class<T> cls, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> selectAll(Class<T> cls) {
		return null;
	}

}
