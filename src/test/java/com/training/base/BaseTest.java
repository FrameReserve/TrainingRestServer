package com.training.base; /**
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


/**   
 * 项目名称：training
 *
 * 类描述：
 * 类名称：com.training.BaseTest
 * 创建人：xxx
 * 创建时间：2016-5-15 下午2:58:48   
 * 修改人：
 * 修改时间：2016-5-15 下午2:58:48   
 * 修改备注：   
 * @version   V1.0    
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-*.xml"})
public abstract class BaseTest {

}
