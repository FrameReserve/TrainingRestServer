   
	 /**     
     * @discription 在此输入一句话描述此文件的作用
     * @author xxx
     * @created 2016-5-29 下午4:32:37    
     * tags     
     * see_to_target     
     */
    
package com.xxx.training.controller.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

  
    /**        
 * Title: UserController.java    
 * Description: 描述
 * @author xxx
 * @created 2016-5-29 下午4:32:37    
 */
@RestController
public class LoginController {
	@RequestMapping("/qqlogin")
	public ModelAndView login(){
		return new ModelAndView("login.html");
	}
}
