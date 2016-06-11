/**
 * 
 */
package com.xxx.training.service;


import org.springframework.data.domain.Page;

import com.xxx.training.entity.domain.Qq;

import java.util.List;

/**
 * @author xxx
 *
 */
public interface QqClient {
	void saveOrUpdate(Qq qq);
	Qq getQq(Qq qq);
	List<Qq> findAll();
	Page<Qq> findAllBySpecification(Qq qq);
}
