package com.training.sysmanager.entity;

import com.training.core.entity.BaseEntity;

/**
 * Created by Athos on 2016-06-29.
 */
public class AclUser extends BaseEntity {

    public AclUser(){}
    public AclUser(String userName, String userPwd){
        this.userName = userName;
        this.userPwd = userPwd;
    }

    private String userName;
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
