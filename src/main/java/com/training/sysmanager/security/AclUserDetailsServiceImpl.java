package com.training.sysmanager.security;

import com.training.sysmanager.entity.AclRole;
import com.training.sysmanager.entity.AclUser;
import com.training.sysmanager.service.aclrole.AclRoleService;
import com.training.sysmanager.service.acluser.AclUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Athos on 2016-07-13.
 */
public class AclUserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private AclUserService aclUserService;
    @Resource
    private AclRoleService aclRoleService;

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        AclUser aclUser = aclUserService.findAclUserByName(username);
        String [] roles = aclUserService.findAclUserRolesByUserName(username).split(",");
        for (String role:roles){
            auths.add(new SimpleGrantedAuthority(role));
        }
        return new User(aclUser.getUserName().toLowerCase(),aclUser.getUserPwd().toLowerCase(),true,true,true,true,auths);
    }
}
