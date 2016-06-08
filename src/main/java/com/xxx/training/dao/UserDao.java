/**
 * 
 */
package com.xxx.training.dao;

import com.xxx.training.dao.*;
import com.xxx.training.entity.domain.User;

/**
 * @author xxx
 *
 */
public interface UserDao extends BaseDao<User,Integer> {
	User findByUsername(String username);
}
