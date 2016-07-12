package com.training.sysmanager.aclroleresources.service;

import com.training.base.BaseTest;
import com.training.sysmanager.entity.AclRoleResources;
import com.training.sysmanager.service.aclroleresources.AclRoleResourcesService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Athos on 2016-07-12.
 */
public class AclRoleResourcesServiceTest extends BaseTest {
    @Resource
    private AclRoleResourcesService aclRoleResourcesService;
    @Test
    public void getEntityByIdTest(){
        AclRoleResources aclRoleResources = new AclRoleResources();
        aclRoleResources = aclRoleResourcesService.getEntityById(1);
        System.out.println(aclRoleResources.getResourceId());
    }
}
