package com.training.sysmanager.dao;

import com.training.sysmanager.entity.AclUser;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Athos on 2016-06-30.
 */
public interface AclUserMapper {
//    @Select("SELECT * FROM tbl_sysmgr_acluser WHERE id = 1")
    AclUser getAclUserById();
}
