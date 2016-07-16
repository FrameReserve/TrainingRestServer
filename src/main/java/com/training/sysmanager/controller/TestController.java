package com.training.sysmanager.controller;

import com.training.core.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * Created by Athos on 2016-07-14.
 */
@RestController
@RequestMapping("/food")
public class TestController extends BaseController {

    @RolesAllowed({"ROLE_FOOD_QUERY"})
    @RequestMapping("/queryFood")
    public void foods(){
        System.out.println("读取食物.....");
    }

    @RolesAllowed({"ROLE_FOODS_CREATE"})
    @RequestMapping("/addFood")
    public  void create(){
        System.out.println("新增食物");
    }
}
