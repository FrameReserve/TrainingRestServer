package com.training.sysmanager.controller;

import com.training.core.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * Created by Athos on 2016-07-14.
 */
@RestController
@RequestMapping("/test1")
public class TestController extends BaseController {

    @RolesAllowed({"ROLE_RESOURCES1"})
    public void method(){
        System.out.println("通过验证");
    }
}
