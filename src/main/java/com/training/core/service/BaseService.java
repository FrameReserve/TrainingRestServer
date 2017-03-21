package com.training.core.service;

import com.training.core.dto.FlexiPageDto;
import com.training.core.entity.BaseEntity;

import java.util.List;

import tk.mybatis.mapper.entity.Example;

public interface BaseService<T extends BaseEntity> {

	/**
	 * 根据Id查询实体
	 */
	public T getEntityById(final Integer id);
	
	/**
	 * 新增实体
	 */
	public void addEntity(final T entity);
	/**
	 * 更新实体
	 */
	public void updateEntity(final T entity);
	
	/**
	 * 根据Id删除实体
	 */
	public void deleteEntityById(final Integer id);

	/**
	 * 查询所有
     */
	public List<T> findAll();
	
	/**
	 * 单表模糊查询
	 */
	public List<T> findByLike(Example example);
	
	/**
	 * 根据模糊分页查询
	 */
	public List<T> findByPage(Example example, FlexiPageDto flexiPageDto);
	
	/**
	 * 单表模糊查询总记录数
	 */
	public int findRowCount(Example example);

}
