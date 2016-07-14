package com.training.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.training.core.annotation.MapperClass;
import com.training.core.entity.BaseEntity;
import com.training.sysmanager.dao.aclroleresources.AclRoleResourcesMapper;
import org.apache.ibatis.type.Alias;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Athos on 2016-06-29.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name = "tbl_sysmgr_aclroleresources")
@Alias("AclRoleResources")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@MapperClass(AclRoleResourcesMapper.class)
public class AclRoleResources extends BaseEntity {
    public AclRoleResources(){};
    public AclRoleResources(Integer roleId,String resourceIds){
        this.roleId = roleId;
        this.resourceIds = resourceIds;
    }

    /**
     * 角色ID
     */
    @Column
    private Integer roleId;
    /**
     * 资源ID,逗号间隔,或者JSON
     */
    @Column
    private String resourceIds;

    /**
     * 资源名称
     */
    @Transient
    private String resourceNames;



    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getResourceNames() {
        return resourceNames;
    }

    public void setResourceNames(String resourceNames) {
        this.resourceNames = resourceNames;
    }
}
