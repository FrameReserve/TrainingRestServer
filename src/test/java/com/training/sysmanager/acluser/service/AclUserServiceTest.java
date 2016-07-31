package com.training.sysmanager.acluser.service;

import com.training.base.BaseTest;
import com.training.sysmanager.entity.AclUser;
import com.training.sysmanager.service.aclrole.AclRoleService;
import com.training.sysmanager.service.acluser.AclUserService;
import org.junit.Test;
import org.springframework.security.acls.model.Acl;

import javax.annotation.Resource;

/**
 * Created by Athos on 2016-07-12.
 */
public class AclUserServiceTest extends BaseTest {
    @Resource
    private AclUserService aclUserService;
    @Resource
    private AclRoleService aclRoleService;

    @Test
    public void getEntityByIdTest(){
        AclUser aclUser = aclUserService.getEntityById(1);
        aclUser.setRoleNames(aclRoleService.findAclRolesByAclUserRoleIds(aclUser.getRoleIds()));
        System.out.println(aclUser.getUserName());
        String [] roles = aclRoleService.findAclRolesByAclUserRoleIds(aclUser.getRoleIds()).split(",");
        System.out.println(aclUser.getRoleNames());
        for (String role:roles){
            System.out.println(role);
        }
    }

    @Test
    public void findAclUserByNameTest(){
        AclUser aclUser = aclUserService.findAclUserByName("test");
        System.out.println(aclUser.getRoleIds());
//        throw new NullPointerException("空指针");
    }
}
