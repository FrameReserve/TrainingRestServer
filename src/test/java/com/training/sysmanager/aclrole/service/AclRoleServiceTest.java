package com.training.sysmanager.aclrole.service;

import com.training.base.BaseTest;
import com.training.sysmanager.entity.AclRole;
import com.training.sysmanager.service.aclrole.AclRoleService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Athos on 2016-07-12.
 */
public class AclRoleServiceTest extends BaseTest {
    @Resource
    private AclRoleService aclRoleService;

    @Test
    public void getEntityByIdTest(){
        AclRole aclRole = aclRoleService.getEntityById(1);
        System.out.println(aclRole.getRoleName());
    }
}
