package com.training.redis.service;

import java.util.Date;

import javax.annotation.Resource;

import com.training.base.BaseTest;
import org.junit.Test;

import com.training.redis.entity.DemoRedis;

public class DemoRedisServiceTest extends BaseTest {

	@Resource
	private DemoRedisService demoRedisService;
	
	@Test
	public void testAddDemoRedis() {
		DemoRedis demoRedis = new DemoRedis();
		demoRedis.setId(1000);
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
