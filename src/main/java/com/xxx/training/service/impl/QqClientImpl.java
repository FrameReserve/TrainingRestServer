/**
 * 
 */
package com.xxx.training.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.xxx.training.dao.QqDao;
import com.xxx.training.entity.domain.Qq;
import com.xxx.training.service.QqClient;
import com.xxx.training.util.SpecificationUtil;
/**
 * @author xxx
 * 
 */
@Service
public class QqClientImpl implements QqClient {
	@Inject
	private QqDao qqDao;

	@Override
	public void saveOrUpdate(Qq qq) {
		qqDao.save(qq);
	}

	@Override
	public Qq getQq(Qq qq) {
		return qqDao.findOne(qq.getId());
	}

	@Override
	public List<Qq> findAll() {
		return (List<Qq>) qqDao.findAll();
	}

	@Override
	public Page<Qq> findAllBySpecification(Qq qq){
		return qqDao.findAll(SpecificationUtil.byParam(qq),new PageRequest(0,10));
	}
}
