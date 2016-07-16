package com.training.sysmanager.service.aclresources.impl;

import com.training.core.service.impl.MyBatisBaseServiceImpl;
import com.training.sysmanager.dao.aclresources.AclResourcesMapper;
import com.training.sysmanager.entity.AclResources;
import com.training.sysmanager.service.aclresources.AclResourcesService;
import com.training.sysmanager.service.aclrole.AclRoleService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Athos on 2016-07-12.
 */
@Service("aclResourcesService")
public class AclResourcesServiceImpl extends MyBatisBaseServiceImpl<AclResources> implements AclResourcesService {

    protected AclResourcesMapper getMapper(){
        return super.getMapper(AclResources.class);
    }

    @Override
    public List<AclResources> selectAclResourcesTypeOfRequest(){
       return getMapper().selectAclResourcesTypeOfRequest();
    }

    @Override
    public List<AclResources> selectAclResourcesByResourceIds(String resourceIds) {
        return getMapper().selectAclResourcesByResourceIds(resourceIds);
    }
}
