package com.training.sysmanager.service.aclrequesttype.impl;

import com.training.core.service.impl.MyBatisBaseServiceImpl;
import com.training.sysmanager.entity.AclRequestType;
import com.training.sysmanager.service.aclrequesttype.AclRequestTypeService;
import org.springframework.stereotype.Service;

/**
 * Created by Athos on 2016-07-12.
 */
@Service("aclRequestTypeService")
public class AclRequestTypeServiceImpl extends MyBatisBaseServiceImpl<AclRequestType> implements AclRequestTypeService{
}
