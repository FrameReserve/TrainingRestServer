package com.training.demo.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.core.controller.BaseController;
import com.training.core.dto.Pair;
import com.training.core.dto.ResultDataDto;
import com.training.demo.dto.DemoSessionDto;

@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {

	/**
	 * 根据Id查询实体
	 */
    @RequestMapping(value = "/getSesstion", method = RequestMethod.GET)
	public @ResponseBody ResultDataDto getEntityById(HttpSession httpSession) {
    	
    	Enumeration<String> sessionkeys = httpSession.getAttributeNames();
    	
    	List<Pair<String, String>> list = new ArrayList<Pair<String,String>>();
    	while (sessionkeys.hasMoreElements()) {
			String key = (String) sessionkeys.nextElement();
			list.add(new Pair<String, String>(key, httpSession.getAttribute(key).toString()));
		}
		return ResultDataDto.addSuccess().setDatas(list);
	}
    
    /**
	 * 新增实体
	 */
    @RequestMapping(value = "/addSesstion", method = RequestMethod.GET)
	public @ResponseBody ResultDataDto addEntity(HttpSession httpSession) {
    	DemoSessionDto session = new DemoSessionDto();
    	session.setKey("testKey");
    	session.setValue("testValue");
    	httpSession.setAttribute(session.getKey(), session.getValue());
		return ResultDataDto.addAddSuccess();
	}
	
}
