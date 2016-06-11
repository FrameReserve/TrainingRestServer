/**  
* @Title: QqController.java
* @Package com.xxx.training.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author xxx
* @date 2016-5-15 下午4:26:08
* @version V1.0  
*/ 
package com.xxx.training.controller.qq;


import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.xxx.training.entity.domain.Qq;
import com.xxx.training.entity.vo.Qqs;
import com.xxx.training.service.QqClient;
import com.xxx.training.util.ProducesClass;
import org.springframework.http.HttpStatus;

/**   
 * 创建人：xxx
 * 创建时间：2016-5-15 下午4:26:08   
 */

@RestController
@RequestMapping("/")
public class QqController {

	@Inject
	private QqClient qqClient;
//	@RolesAllowed({"ROLE_ABCS"})
	@RequestMapping(value="/test/{id}",method=RequestMethod.GET,produces={ProducesClass.APPLICATION_XML_UTF8,ProducesClass.APPLICATION_XHTML_XML_UTF8,ProducesClass.APPLICATION_JSON_UTF8,ProducesClass.TEXT_HTML_UTF8})
	@ResponseStatus(HttpStatus.OK)
	public Qq test(@PathVariable("id")Integer id){
		Qq qq = new Qq();
		qq.setId(id);
        System.out.println("id = [" + id + "]");
        return qqClient.getQq(qq);
	}
	
	@RequestMapping(value="/listqq",method=RequestMethod.GET,produces={ProducesClass.APPLICATION_XML_UTF8,ProducesClass.APPLICATION_XHTML_XML_UTF8,ProducesClass.APPLICATION_JSON_UTF8,ProducesClass.TEXT_HTML_UTF8})
	@ResponseStatus(HttpStatus.OK)
	public List<Qq> listQq(){
		return qqClient.findAll();
	}
	@RolesAllowed({"ROLE_ADMIN"})
	@RequestMapping(value="/qqs",method=RequestMethod.GET,produces={ProducesClass.APPLICATION_XML_UTF8,ProducesClass.APPLICATION_XHTML_XML_UTF8,ProducesClass.APPLICATION_JSON_UTF8,ProducesClass.TEXT_HTML_UTF8})
	@ResponseStatus(HttpStatus.OK)
	public Qqs qqs(){
		return new Qqs(qqClient.findAll());
	}


	@RequestMapping(value = "/qq/add",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String add(@ModelAttribute("qq") @Valid Qq qq, BindingResult result){if (result.hasErrors())return "error";return "success";}
	
	
	@RequestMapping(value="/pages",method=RequestMethod.GET,produces={ProducesClass.APPLICATION_XML_UTF8,ProducesClass.APPLICATION_XHTML_XML_UTF8,ProducesClass.APPLICATION_JSON_UTF8,ProducesClass.TEXT_HTML_UTF8})
	@ResponseStatus(HttpStatus.OK)
	public Qqs pages(){
		return new Qqs(qqClient.findAllBySpecification(new Qq()).getContent());
	}
	
	@RequestMapping(value="/tohtml",method=RequestMethod.GET,produces={ProducesClass.TEXT_HTML_UTF8})
	public ModelAndView testToHTML(){
		return new ModelAndView("error.html");
	}
}
