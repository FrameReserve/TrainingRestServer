package com.training.sysmanager.service.aclrequesttype.impl;

import com.training.core.service.impl.MyBatisBaseServiceImpl;
import com.training.sysmanager.mapper.aclrequesttype.AclRequestTypeMapper;
import com.training.sysmanager.entity.AclRequestType;
import com.training.sysmanager.service.aclrequesttype.AclRequestTypeService;
import org.springframework.stereotype.Service;

/**
 * Created by Athos on 2016-07-12.
 */
@Service("aclRequestTypeService")
public class AclRequestTypeServiceImpl extends MyBatisBaseServiceImpl<AclRequestType> implements AclRequestTypeService{

    protected AclRequestTypeMapper getMapper(){
        return super.getMapper(AclRequestType.class);
    }

    @Override
    public String findPronounStrByRequestTypeIds(String requestTypeIds) {
        return this.getMapper().findPronounStrByRequestTypeIds(requestTypeIds);
    }

    @Override
    public int selectCountByNeId(AclRequestType aclRequestType){
        return 0;
    }
}
