package com.training.core.service.impl;

import com.training.core.entity.BaseEntity;
import com.training.core.service.BaseService;

import java.util.List;

public class JpaBaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	@Override
	public T getEntityById(Integer id) {
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
	public void deleteEntityById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> selectAll() {
		return null;
	}

}
