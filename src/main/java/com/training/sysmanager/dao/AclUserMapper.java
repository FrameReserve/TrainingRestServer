package com.training.sysmanager.dao;

import com.training.sysmanager.entity.AclUser;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Athos on 2016-06-30.
 */
public interface AclUserMapper extends Mapper<AclUser> {
//    @Select("SELECT * FROM tbl_sysmgr_acluser WHERE id = 1")
//    AclUser getAclUserById();
}
