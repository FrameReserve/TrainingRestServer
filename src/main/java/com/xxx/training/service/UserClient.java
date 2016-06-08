/**
 * 
 */
package com.xxx.training.service;

import com.xxx.training.entity.domain.User;


/**
 * @author xxx
 *
 */
public interface UserClient {
    User findByUsername(String username);
    User save(User user);
}
