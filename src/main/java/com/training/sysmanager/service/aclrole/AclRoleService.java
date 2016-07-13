package com.training.sysmanager.service.aclrole;

import com.training.core.service.BaseService;
import com.training.sysmanager.entity.AclRole;
import org.springframework.stereotype.Service;

/**
 * Created by Athos on 2016-07-12.
 */
public interface AclRoleService extends BaseService<AclRole> {
    /**
     *  根据AclUser的属性值查询返回逗号间隔的角色集字符串
     */
    String findAclRolesByAclUserRoleIds(String roleIds);
}