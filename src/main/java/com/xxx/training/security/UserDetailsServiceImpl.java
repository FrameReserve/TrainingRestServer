/**
 * 
 */
package com.xxx.training.security;



import com.xxx.training.entity.domain.Roles;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.xxx.training.service.RolesClient;
import org.springframework.security.core.GrantedAuthority;
import com.xxx.training.service.UserClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import javax.inject.Inject;

/**
 * @author xxx
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Inject
	private UserClient userClient;
    @Inject
    private RolesClient rolesClient;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		com.xxx.training.entity.domain.User user = userClient.findByUsername(username);
        List<Roles> list = rolesClient.findRolesByUserName(username);
        for (Roles roles:list){
            auths.add(new SimpleGrantedAuthority(roles.getName()));
        }
        boolean enables = true;
        boolean accountNonexpired = true;
        boolean credentialsNonexpird = true;
        boolean accountNonlocked = true;
        org.springframework.security.core.userdetails.User userdetail = new com.xxx.training.security.SecurityUser(user.getUsername(),user.getPassword(),enables,accountNonexpired,credentialsNonexpird,accountNonlocked,auths);
		return userdetail;
	}

}
