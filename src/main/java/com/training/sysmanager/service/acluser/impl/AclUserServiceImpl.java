package com.training.sysmanager.service.acluser.impl;

import com.training.core.annotation.ServiceLog;
import com.training.core.service.impl.MyBatisBaseServiceImpl;
import com.training.sysmanager.mapper.acluser.AclUserMapper;
import com.training.sysmanager.entity.AclUser;
import com.training.sysmanager.service.acluser.AclUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Athos on 2016-07-02.
 */
@Service("aclUserService")
public class AclUserServiceImpl extends MyBatisBaseServiceImpl<AclUser> implements AclUserService {
    @ServiceLog(description = "根据用户名查询用户")
    @Override
    public AclUser findAclUserByName(String userName) {
//        if(userName.length()>0){
//            throw new RuntimeException("长度大于一,模拟错误");
//        }
        return this.getMapper().findAclUserByName(userName);
    }

    protected AclUserMapper getMapper(){
        return super.getMapper(AclUser.class);
    }
}
