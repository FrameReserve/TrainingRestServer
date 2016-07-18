package com.training.sysmanager.controller;

import com.training.core.controller.BaseController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Athos on 2016-07-14.
 */
@RestController
@RequestMapping("/food")
public class TestController extends BaseController {

    @PreAuthorize("hasAuthority('AUTH_FOOD_QUERY')")
    @RequestMapping(value = "/queryFood")
    public void foods(){
        System.out.println("读取食物.....");
    }

    @PreAuthorize("hasAuthority('AUTH_FOOD_ADD')")
    @RequestMapping("/addFood")
    public  void add(){
        System.out.println("新增食物");
    }
}
