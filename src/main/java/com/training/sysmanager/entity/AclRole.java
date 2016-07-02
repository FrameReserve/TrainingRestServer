package com.training.sysmanager.entity;

import com.training.core.entity.BaseEntity;

/**
 * Created by Athos on 2016-06-29.
 */
public class AclRole extends BaseEntity {
    public AclRole(){}
    public AclRole(String roleName){
        this.roleName = roleName;
    }

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public AclRole setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
}
