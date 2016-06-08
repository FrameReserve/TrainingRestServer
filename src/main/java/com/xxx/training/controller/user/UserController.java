/**
 * 
 */
package com.xxx.training.controller.user;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RestController;

import com.xxx.training.service.UserClient;

/**
 * @author xxx
 *
 */
@RestController
public class UserController {
	@Inject
	private UserClient userClient;
}
