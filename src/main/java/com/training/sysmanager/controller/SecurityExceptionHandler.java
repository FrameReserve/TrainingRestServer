package com.training.sysmanager.controller;

import com.training.core.controller.BaseController;
import com.training.core.dto.ResultDataDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Athos on 2016-07-17.
 */
@RestController
@RequestMapping("/securityException")
public class SecurityExceptionHandler extends BaseController{

    @RequestMapping(value = "/accessDenied")
    public ResultDataDto accessDenied(){
        return new ResultDataDto(ResultDataDto.CODE_SUCCESS,"拒绝访问!");
    }

    @RequestMapping(value = "/badCredentialsException")
    public ResultDataDto badCredentialsException(){
        return new ResultDataDto(ResultDataDto.CODE_SUCCESS,"密码错误!");
    }

    @RequestMapping(value = "/authenticationException",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseStatus(HttpStatus.OK)
    public ResultDataDto authenticationException(){
        return new ResultDataDto(ResultDataDto.CODE_SUCCESS,"验证失败!");
    }
}
