package com.training.core.dao.impl;

import com.training.core.helper.MyBatisHelper;
import org.springframework.stereotype.Repository;

import com.training.core.dao.BaseDao;
import com.training.core.entity.BaseEntity;
import tk.mybatis.mapper.common.BaseMapper;

@Repository("myBatisBaseDao")
public class MyBatisBaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
	private MyBatisHelper myBatisHelper = new MyBatisHelper();
	public <T extends BaseMapper> T getMapper(Class cls){
		return (T)myBatisHelper.getMapper(cls);
	}
	@Override
	public T getEntityById(Class<T> cls, Integer id) {
		return (T) this.getMapper(cls).selectByPrimaryKey(id);
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
