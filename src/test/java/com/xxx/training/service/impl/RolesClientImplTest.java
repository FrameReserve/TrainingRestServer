package com.xxx.training.service.impl;

import com.xxx.training.BaseTest;

import com.xxx.training.service.RolesClient;
import javax.inject.Inject;
import org.junit.Test;
import com.xxx.training.entity.domain.Roles;

import java.util.List;


/**
 * Created by xxx on 2016-06-05.
 */
public class RolesClientImplTest extends BaseTest {
    @Inject
    private RolesClient rolesClient;
    @Test
    public void save(){
        Roles roles = new Roles();
        roles.setName("guest");
        roles.setUserName("guest");
        rolesClient.save(roles);
    }

    @Test
    public void findRolesByUserName(){
      rolesClient.findRolesByUserName("guest");
    }

    @Test
    public void findRolesNameByUserName(){
      List<Roles> list = rolesClient.findRolesByUserName("guest");
        System.out.println(list.get(0).getName());
    }

    @Test
    public void findAll(){
        System.out.print(rolesClient.findAll().get(0).getName());
    }
}
