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
@Table(name = "tbl_sysmgr_aclroleresources")
@TypeAlias("AclRoleResources")
public class AclRoleResources extends BaseEntity {
    public AclRoleResources(){};
    public AclRoleResources(Integer aclRoleId,Integer aclResourceId){
        this.aclRoleId = aclRoleId;
        this.aclResourceId = aclResourceId;
    }

    /**
     * 角色ID
     */
    private Integer aclRoleId;
    /**
     * 资源ID
     */
    private Integer aclResourceId;

    public Integer getAclRoleId() {
        return aclRoleId;
    }

    public void setAclRoleId(Integer aclRoleId) {
        this.aclRoleId = aclRoleId;
    }

    public Integer getAclResourceId() {
        return aclResourceId;
    }

    public void setAclResourceId(Integer aclResourceId) {
        this.aclResourceId = aclResourceId;
    }
}
