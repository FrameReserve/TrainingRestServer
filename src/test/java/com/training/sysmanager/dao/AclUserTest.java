package com.training.sysmanager.dao;

import com.training.base.BaseTest;
import com.training.sysmanager.entity.AclUser;
import com.training.sysmanager.service.AclUserService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Athos on 2016-06-30.
 */
public class AclUserTest extends BaseTest {
    @Resource
    private AclUserService aclUserService;

    @Test
    public void testGetEntityById(){
     AclUser aclUser = aclUserService.getEntityById(1);
        System.out.println(aclUser.getUserName());
    }

}
