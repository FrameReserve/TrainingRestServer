package com.training.core.dao;

import java.util.List;

import com.training.core.dto.CriteriaDto;
import com.training.core.dto.FlexiPageDto;
import com.training.core.entity.MongodbBaseEntity;

public interface MongodbBaseDao<T extends MongodbBaseEntity> {

	public T getEntityById(Class<T> cls, String id);

	public void addEntity(T entity);

	public void updateEntity(T entity);

	public void deleteEntityById(Class<T> cls, String id);

	public List<T> findAll(Class<T> cls);

	public List<T> findByLike(CriteriaDto<T> criteriaDto);

	public List<T> findByPage(CriteriaDto<T> criteriaDto, FlexiPageDto flexiPageDto);

	public long findRowCount(CriteriaDto<T> criteriaDto);
	
}
