package com.training.sysmanager.service.acluser.impl;

import org.springframework.stereotype.Service;

import com.training.core.service.impl.MyBatisBaseServiceImpl;
import com.training.sysmanager.entity.AclUser;
import com.training.sysmanager.mapper.acluser.AclUserMapper;
import com.training.sysmanager.service.acluser.AclUserService;


/**
 * Created by Athos on 2016-07-02.
 */
@Service("aclUserService")
public class AclUserServiceImpl extends MyBatisBaseServiceImpl<AclUser> implements AclUserService {
	
    @Override
    public AclUser findAclUserByName(String userName) {
        return this.getMapper().findAclUserByName(userName);
    }
    
    protected AclUserMapper getMapper(){
        return super.getMapper(AclUser.class);
    }
}
