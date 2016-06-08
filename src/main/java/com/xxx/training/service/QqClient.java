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
	public void saveOrUpdate(Qq qq);
	public Qq getQq(Qq qq);
	public List<Qq> findAll();
	public Page<Qq> findAllBySpecification(Qq qq);
}
