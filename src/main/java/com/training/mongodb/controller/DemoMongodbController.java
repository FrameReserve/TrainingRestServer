package com.training.mongodb.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.core.controller.BaseMongodbController;
import com.training.core.dto.ResultDataDto;
import com.training.mongodb.entity.DemoMongodb;
import com.training.mongodb.service.DemoMongodbService;

@RestController
@RequestMapping("/mongodb")
public class DemoMongodbController extends BaseMongodbController<DemoMongodb> {

	@Resource
	private DemoMongodbService demoMongodbService;
    
	/**
	 * 新增实体
	 */
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResultDataDto addEntity(@RequestBody final DemoMongodb entity) {
    	demoMongodbService.addEntity(entity);
		return ResultDataDto.addAddSuccess();
	}
	
	/**
	 * 更新实体
	 */
    @RequestMapping(value = "/updateEntity", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody ResultDataDto updateEntity(@RequestBody final DemoMongodb entity) {
    	demoMongodbService.updateEntity(entity);
		return ResultDataDto.addUpdateSuccess();
	}
    
}
