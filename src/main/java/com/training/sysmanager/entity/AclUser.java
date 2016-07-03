package com.training.sysmanager.entity;

import com.training.core.entity.BaseEntity;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by Athos on 2016-06-29.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name="tbl_sysmgr_acluser")
public class AclUser extends BaseEntity {

    public AclUser(){}
    public AclUser(String userName, String userPwd){
        this.userName = userName;
        this.userPwd = userPwd;
    }
    @Column
    private String userName;
    @Column
    private String userPwd;

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
}
