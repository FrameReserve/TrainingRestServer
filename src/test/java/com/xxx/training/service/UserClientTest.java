/**
 * 
 */
package com.xxx.training.service;

import javax.inject.Inject;
import org.junit.Test;
import com.xxx.training.entity.domain.Roles;
import com.xxx.training.BaseTest;
import com.xxx.training.entity.domain.User;
import java.util.List;

/**
 * @author xxx
 *
 */

public class UserClientTest extends BaseTest {
	@Inject
	private UserClient userClient;
	@Test
	public void getByName(){
		User user = userClient.findByUsername("guest");
	}

    @Test
    public void save(){
        User user = new User();
        user.setQq(123456);
        user.setUserName("testBaseEntity");
        user.setPassword("123");
        userClient.save(user);
    }
}
