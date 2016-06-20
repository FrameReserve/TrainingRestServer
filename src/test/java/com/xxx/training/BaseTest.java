package com.xxx.training; /**
 * @Title: BaseTest.java
 * @Package com.xxx.training
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xxx
 * @date 2016-5-15 下午2:58:48
 * @version V1.0
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * 项目名称：training
 *
 * 类描述：
 * 		2016-06-20,去除：spring-quartz.xml，定时任务只测试Service。
 * 					增加：spring-redis.xml
 * 类名称：com.xxx.training.BaseTest
 * 创建人：xxx
 * 创建时间：2016-5-15 下午2:58:48   
 * 修改人：
 * 修改时间：2016-5-15 下午2:58:48   
 * 修改备注：   
 * @version V1.0
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath*:spring-bean.xml"})

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration(locations ={"classpath*:spring-mvc.xml","classpath*:spring-bean.xml","classpath*:spring-jpa.xml","classpath*:spring-druid.xml","classpath*:spring-security.xml","classpath*:spring-quartz.xml","classpath*:spring-redis.xml"})
@ContextConfiguration(locations ={"classpath*:spring-mvc.xml","classpath*:spring-bean.xml","classpath*:spring-jpa.xml","classpath*:spring-druid.xml","classpath*:spring-security.xml","classpath*:spring-redis.xml"})
public abstract class BaseTest {

}
