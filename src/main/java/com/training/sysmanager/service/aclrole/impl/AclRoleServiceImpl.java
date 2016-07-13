package com.training.sysmanager.service.aclrole.impl;

import com.training.core.service.impl.MyBatisBaseServiceImpl;
import com.training.sysmanager.dao.aclrole.AclRoleMapper;
import com.training.sysmanager.entity.AclRole;
import com.training.sysmanager.service.aclrole.AclRoleService;
import org.springframework.stereotype.Service;

/**
 * Created by Athos on 2016-07-12.
 */
@Service("aclRoleService")
public class AclRoleServiceImpl extends MyBatisBaseServiceImpl<AclRole> implements AclRoleService{

    protected AclRoleMapper getMapper(){
        return super.getMapper(AclRole.class);
    }

    @Override
    public String findAclRolesByAclUserRoleses(String roleses) {
        return this.getMapper().findAclRolesByAclUserRoleses(roleses);
    }
}