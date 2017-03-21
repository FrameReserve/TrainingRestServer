package com.training.core.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.core.dao.MongodbBaseDao;
import com.training.core.dto.ResultDataDto;
import com.training.core.entity.MongodbBaseEntity;
import com.training.core.util.GenericeClassUtils;

public class BaseMongodbController<T extends MongodbBaseEntity> extends BaseController<T> {

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);
	
	@Resource(name = "mongodbBaseDao")
	protected MongodbBaseDao<T> baseDao;
	
	/**
	 * 根据Id查询实体
	 */
    @RequestMapping(value = "/getEntityById/{id}", method = RequestMethod.GET)
	public @ResponseBody ResultDataDto getEntityById(@PathVariable(value = "id") final String id) {
    	T entity = baseDao.getEntityById(entityClass, id);
		return new ResultDataDto().setDatas(entity);
	}
	
	/**
	 * 根据Id删除实体
	 */
	@RequestMapping(value = "/deleteEntityById/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResultDataDto deleteEntityById(@PathVariable(value = "id") final String id) {
		baseDao.deleteEntityById(entityClass, id);
		return ResultDataDto.addDeleteSuccess();
	}
	
	/**
	 * 查询所有实体
	 */
	@RequestMapping(value = "/findAllEntitys", method = RequestMethod.GET)
	public @ResponseBody ResultDataDto findAllEntitys() {
		List<T> list = baseDao.findAll(entityClass);
		return new ResultDataDto().setDatas(list);
	}
	
}
