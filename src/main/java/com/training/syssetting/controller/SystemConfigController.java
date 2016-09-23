package com.training.syssetting.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.core.controller.BaseController;
import com.training.syssetting.entity.SystemConfig;
import com.training.syssetting.service.SystemConfigService;

@RestController
@RequestMapping("/syssetting")
public class SystemConfigController extends BaseController<SystemConfig> {

	@Resource
	private SystemConfigService systemConfigService;
	
}
