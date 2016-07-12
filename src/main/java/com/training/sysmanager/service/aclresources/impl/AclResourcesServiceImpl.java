package com.training.sysmanager.service.aclresources.impl;

import com.training.core.service.impl.MyBatisBaseServiceImpl;
import com.training.sysmanager.entity.AclResources;
import com.training.sysmanager.service.aclresources.AclResourcesService;
import com.training.sysmanager.service.aclrole.AclRoleService;
import org.springframework.stereotype.Service;

/**
 * Created by Athos on 2016-07-12.
 */
@Service("aclResourcesService")
public class AclResourcesServiceImpl extends MyBatisBaseServiceImpl<AclResources> implements AclResourcesService {
}
