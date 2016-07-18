package com.training.sysmanager.controller;

import com.training.core.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Athos on 2016-07-17.
 */
@RestController
@RequestMapping("/securityException")
public class SecurityExceptionHandler extends BaseController{

    @RequestMapping(value = "/accessDenied")
    public void accessDenied(){
        throw new RuntimeException("拒绝访问!");
    }

    @RequestMapping(value = "/authenticationException")
    public void authenticationException(){
        throw new RuntimeException("登录验证失败!");
    }

    @RequestMapping(value = "/badCredentialsException")
    public void badCredentialsException(){
        throw new RuntimeException("密码错误!");
    }
}
