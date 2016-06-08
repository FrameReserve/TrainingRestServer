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

import com.xxx.training.security.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
public class QqController {
	@Inject
	private QqClient qqClient;
	@RolesAllowed({"ROLE_ABCS"})
	@RequestMapping(value="/test/{id}",method=RequestMethod.GET,produces={ProducesClass.APPLICATION_XML_UTF8,ProducesClass.APPLICATION_XHTML_XML_UTF8,ProducesClass.APPLICATION_JSON_UTF8,ProducesClass.TEXT_HTML_UTF8})
	@ResponseStatus(HttpStatus.OK)
	public Qq test(@PathVariable("id")Integer id){
		Qq qq = new Qq();
		qq.setId(id);
        SecurityUser securityUser = (SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(securityUser.getUsername());
        System.out.println(securityUser.toString());
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
