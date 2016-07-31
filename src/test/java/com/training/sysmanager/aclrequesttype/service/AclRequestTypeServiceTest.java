package com.training.sysmanager.aclrequesttype.service;

import com.training.base.BaseTest;
import com.training.sysmanager.entity.AclRequestType;
import com.training.sysmanager.service.aclrequesttype.AclRequestTypeService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Athos on 2016-07-12.
 */
public class AclRequestTypeServiceTest extends BaseTest {
    @Resource
    private AclRequestTypeService aclRequestTypeService;

    @Test
    public void getEntityByIdTest(){
        AclRequestType aclRequestType = new AclRequestType();
        aclRequestType = aclRequestTypeService.getEntityById(1);
        System.out.println(aclRequestType.getCreateTime());
    }

}
