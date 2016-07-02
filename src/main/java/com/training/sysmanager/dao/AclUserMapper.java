package com.training.sysmanager.dao;

import com.training.sysmanager.entity.AclUser;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Athos on 2016-06-30.
 */
public interface AclUserMapper {
    @Select("select * from tbl_sysmgr_acluser where id = 1")
    public AclUser getAclUserById();
}
