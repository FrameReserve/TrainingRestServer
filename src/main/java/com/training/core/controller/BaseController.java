package com.training.core.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.training.core.dao.BaseDao;
import com.training.core.dto.ResultDataDto;
import com.training.core.entity.BaseEntity;
import com.training.core.util.GenericeClassUtils;

public class BaseController<T extends BaseEntity> {

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);
	
	@Resource(name = "myBatisBaseDao")protected BaseDao<T> baseDao;
	
	// 异常信息拦截，统一处理返回
    @ExceptionHandler(Exception.class)   //在Controller类中添加该注解方法即可(注意：添加到某个controller，只针对该controller起作用)  
    public void exceptionHandler(Exception ex, HttpServletResponse response, HttpServletRequest request) throws IOException {    
        
    	ResultDataDto resultDataDto = new ResultDataDto(ex);
        response.setContentType("text/html");
		response.getWriter().write(new Gson().toJson(resultDataDto));
    }
    
    /**
	 * 根据Id查询实体
	 */
    @RequestMapping(value = "/getEntityById/{id}", method = RequestMethod.GET)
	public @ResponseBody ResultDataDto getEntityById(@PathVariable(value = "id") final Integer id) {
    	T entity = baseDao.getEntityById(entityClass, id);
		return new ResultDataDto(entity);
	}
	
	/**
	 * 新增实体
	 */
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResultDataDto addEntity(@RequestBody final T entity) {
		baseDao.addEntity(entity);
		return ResultDataDto.addAddSuccess();
	}
	
	/**
	 * 更新实体
	 */
    @RequestMapping(value = "/updateEntity", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody ResultDataDto updateEntity(@RequestBody final T entity) {
		baseDao.updateEntity(entity);
		return ResultDataDto.addUpdateSuccess();
	}
	
	/**
	 * 根据Id删除实体
	 */
	@RequestMapping(value = "/deleteEntityById/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResultDataDto deleteEntityById(@PathVariable(value = "id") final Integer id) {
		baseDao.deleteEntityById(entityClass, id);
		return ResultDataDto.addDeleteSuccess();
	}
    
}
