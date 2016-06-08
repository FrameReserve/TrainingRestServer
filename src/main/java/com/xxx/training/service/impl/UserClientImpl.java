/**
 * 
 */
package com.xxx.training.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.xxx.training.entity.domain.User;
import com.xxx.training.service.UserClient;
/**
 * @author xxx
 *
 */
@Service
public class UserClientImpl implements UserClient {
	@Inject
	private com.xxx.training.dao.UserDao userDao;
	/* (non-Javadoc)
	 * @see com.xxx.training.service.UserClient#findByUserName(java.lang.String)
	 */
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
    @Override
    public User save(User user){return userDao.save(user);}

}
