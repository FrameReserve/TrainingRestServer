package com.xxx.training.service;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.xxx.training.BaseTest;
import com.xxx.training.entity.domain.DemoRedis;

public class DemoRedisServiceTest extends BaseTest {

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
