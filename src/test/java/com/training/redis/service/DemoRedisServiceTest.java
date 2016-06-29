package com.training.redis.service;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.training.redis.entity.DemoRedis;
import com.xxx.training.BaseTest;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration(locations ={"classpath*:spring-mvc.xml","classpath*:spring-bean.xml","classpath*:spring-jpa.xml","classpath*:spring-druid.xml","classpath*:spring-security.xml","classpath*:spring-quartz.xml","classpath*:spring-redis.xml"})
@ContextConfiguration(locations ={"classpath*:spring-redis.xml"})
public class DemoRedisServiceTest {

	@Inject
	private DemoRedisService demoRedisService;
	
	@Test
	public void testAddDemoRedis() {
		DemoRedis demoRedis = new DemoRedis();
		demoRedis.setId("1000");
		demoRedis.setCreateTime(new Date());
		demoRedis.setLastModifyTime(new Date());
		demoRedisService.addEntity(demoRedis);
	}
	
	@Test
	public void testGetDemoRedisById() {
		DemoRedis demoRedis = demoRedisService.getEntityById(1000);
		System.out.println(demoRedis.getCreateTime());
		System.out.println();
	}
	
}
