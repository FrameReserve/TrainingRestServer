package com.xxx.training.service;

import javax.inject.Inject;
import org.junit.Test;
import org.springframework.data.domain.Page;
import com.xxx.training.BaseTest;
import com.xxx.training.entity.domain.Qq;
public class QqDaoTest extends BaseTest {
	@Inject
	private QqClient qqClient;

	@Test
	public void testAddQq() {
		Qq qq = new Qq();
		qq.setId(new Integer("4"));
		qq.setQq(new Integer("12"));
		qqClient.saveOrUpdate(qq);
	}

	@Test
	public void findQqByPageable() {
		Qq qq = new Qq();
//		 qq.setId(new Integer("4"));
//		 qq.setQq(new Integer("12"));

		Page<Qq> page = qqClient.findAllBySpecification(qq);
		 System.out.println(page.getContent());
	}
}
