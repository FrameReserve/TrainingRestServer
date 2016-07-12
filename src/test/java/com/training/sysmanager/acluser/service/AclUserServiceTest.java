package com.training.sysmanager.acluser.service;

import com.training.base.BaseTest;
import com.training.sysmanager.entity.AclUser;
import com.training.sysmanager.service.acluser.AclUserService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Athos on 2016-07-12.
 */
public class AclUserServiceTest extends BaseTest {
    @Resource
    private AclUserService aclUserService;

    @Test
    public void getEntityByIdTest(){
      AclUser aclUser = aclUserService.getEntityById(1);
        System.out.println(aclUser.getUserName());
    }
}
