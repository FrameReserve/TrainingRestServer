package com.training.core.dao.impl;

import com.training.core.annotation.MapperClass;
import com.training.core.helper.MyBatisHelper;
import org.springframework.stereotype.Repository;

import com.training.core.dao.BaseDao;
import com.training.core.entity.BaseEntity;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

@Repository("myBatisBaseDao")
@SuppressWarnings("unchecked")
public class MyBatisBaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
	@Resource
	private MyBatisHelper myBatisHelper;
	public <M extends Mapper<T>> M getMapper(Class cls){
		MapperClass mapperClass = (MapperClass) cls.getAnnotation(MapperClass.class);
		if(null == mapperClass){
			throw new RuntimeException("没有注解MapperClass");
		}
		 	return (M)myBatisHelper.getMapper(mapperClass.value());
	}

	@Override
	public T getEntityById(Class<T> cls, Integer id) {
		return this.getMapper(cls).selectByPrimaryKey(id);
	}

	@Override
	public void addEntity(T entity) {
		this.getMapper(entity.getClass()).insert(entity);
	}

	@Override
	public void updateEntity(T entity) {
		this.getMapper(entity.getClass()).updateByPrimaryKey(entity);
	}

	@Override
	public void deleteEntityById(Class<T> cls, Integer id) {
		this.getMapper(cls).deleteByPrimaryKey(id);
	}

}
