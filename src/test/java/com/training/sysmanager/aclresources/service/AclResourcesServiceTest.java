package com.training.sysmanager.aclresources.service;

import com.training.base.BaseTest;
import com.training.sysmanager.entity.AclResources;
import com.training.sysmanager.service.aclrequesttype.AclRequestTypeService;
import com.training.sysmanager.service.aclresources.AclResourcesService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Athos on 2016-07-12.
 */
public class AclResourcesServiceTest extends BaseTest {
    @Resource
    private AclResourcesService aclResourcesService;

    @Resource
    private AclRequestTypeService aclRequestTypeService;

    @Test
    public void getEntityByIdTest(){
        AclResources aclResources = new AclResources();
        aclResources = aclResourcesService.getEntityById(1);
        System.out.println(aclResources.getPronoun());
    }

    @Test
    public void selectAllTest(){
        List<AclResources> aclResourcesList = new ArrayList<AclResources>();
        aclResourcesList = aclResourcesService.selectAll();
        for(AclResources aclResources : aclResourcesList){
            System.out.println(aclResources.getUrl());
        }
    }
}
