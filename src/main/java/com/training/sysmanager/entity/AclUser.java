package com.training.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.training.core.annotation.MapperClass;
import com.training.core.entity.BaseEntity;
import com.training.sysmanager.dao.AclUserMapper;
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
@Table(name="tbl_sysmgr_acluser")
@Alias("AclUser")
@MapperClass(AclUserMapper.class)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AclUser extends BaseEntity {
    public AclUser(){}
    public AclUser(String userName, String userPwd){
        this.userName = userName;
        this.userPwd = userPwd;
    }

    /**
     * 用户名
     */
    @Column
    private String userName;
    /**
     * 密码
     */
    @Column
    private String userPwd;
    /**
     * 角色 json 格式 或转换为数组
     */
    @Column
    private String aclRoles;

    /**
     * 转换为数据 瞬时
     */
    @Transient
    private String aclRoleses;

    public String getUserName() {
        return userName;
    }

    public AclUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public AclUser setUserPwd(String userPwd) {
        this.userPwd = userPwd;
        return this;
    }

    public String getAclRoles() {
        return aclRoles;
    }

    public void setAclRoles(String aclRoles) {
        this.aclRoles = aclRoles;
    }

    public String getAclRoleses() {
        return aclRoleses;
    }

    public void setAclRoleses(String aclRoleses) {
        this.aclRoleses = aclRoleses;
    }
}
