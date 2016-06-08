package com.xxx.training.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by xxx on 2016-06-07.
 */
public class SecurityUser extends org.springframework.security.core.userdetails.User {

    public SecurityUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    @Override
    public String toString(){
        return "ok";
    }
}
