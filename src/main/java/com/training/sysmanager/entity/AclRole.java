package com.training.sysmanager.entity;

import com.training.core.entity.BaseEntity;
import org.springframework.data.annotation.TypeAlias;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

/**
 * Created by Athos on 2016-06-29.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name = "tbl_sysmgr_aclrole")
@TypeAlias("AclRole")
public class AclRole extends BaseEntity {
    public AclRole(){}
    public AclRole(String roleName){
        this.roleName = roleName;
    }

    /**
     * 角色名
     */
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public AclRole setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
}
