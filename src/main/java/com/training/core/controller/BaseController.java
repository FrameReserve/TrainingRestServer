package com.training.core.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.google.gson.Gson;
import com.training.core.dto.ResultDataDto;
import com.training.core.entity.BaseEntity;
import com.training.core.util.GenericeClassUtils;

public class BaseController<T extends BaseEntity> {

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);
	
	// 异常信息拦截，返回
    @ExceptionHandler(Exception.class)   //在Controller类中添加该注解方法即可(注意：添加到某个controller，只针对该controller起作用)  
    public void exceptionHandler(Exception ex, HttpServletResponse response, HttpServletRequest request) throws IOException {    
        
    	ResultDataDto resultDataDto = new ResultDataDto(ex);
        response.setContentType("text/html");
		response.getWriter().write(new Gson().toJson(resultDataDto));
    }
    
}
