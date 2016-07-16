package com.training.sysmanager.service.aclroleresources.impl;

import com.training.core.service.impl.MyBatisBaseServiceImpl;
import com.training.sysmanager.dao.aclroleresources.AclRoleResourcesMapper;
import com.training.sysmanager.entity.AclRoleResources;
import com.training.sysmanager.service.aclroleresources.AclRoleResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Athos on 2016-07-12.
 */
@Service("aclRoleResourcesService")
public class AclRoleResourcesServiceImpl extends MyBatisBaseServiceImpl<AclRoleResources> implements AclRoleResourcesService{

    protected AclRoleResourcesMapper getMapper(){
        return super.getMapper(AclRoleResources.class);
    }

    @Override
    public String selectResourceIdsByRoleIds(String roleIds) {
        String resourceIds = this.getMapper().selectResourceIdsByRoleIds(roleIds);
        String [] resourceIdsArray = resourceIds.split(",");
        ArrayList<String> list = new ArrayList();
        for(String resourceId : resourceIdsArray){
            if(!list.contains(resourceId)){
                list.add(resourceId);
            }
        }
        return StringUtils.join(list.toArray(),",");
    }
}
