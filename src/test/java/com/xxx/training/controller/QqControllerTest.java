/**  
 * @Title: QqControllerTest.java
 * @Package com.xxx.training.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xxx
 * @date 2016-5-16 上午9:06:08
 * @version V1.0  
 */
package com.xxx.training.controller;

import java.io.IOException;

import com.xxx.training.entity.domain.Qq;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
/**
 * 项目名称：training
 * 
 * 类描述： 类名称：com.xxx.training.controller.QqControllerTest 创建人：xxx
 * 创建时间：2016-5-16 上午9:06:08 修改人： 修改时间：2016-5-16 上午9:06:08 修改备注：
 * 
 * @version V1.0
 */

public class QqControllerTest {
	@Test
	public void testQqController() {
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		CloseableHttpResponse response;
		HttpGet doGet = new HttpGet("http://localhost:8080/test/11");
		try {
			response = closeableHttpClient.execute(doGet);
			HttpEntity entity = response.getEntity();
			ObjectMapper mapper = new ObjectMapper();
//			Qq qq = mapper.readValue(entity.getContent(),Qq.class);
//			System.out.println(qq.getQq());
			System.out.println(response.getEntity().getContentEncoding());
			response.close();
			closeableHttpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@Test
	public void testJason() throws JsonProcessingException{
		Qq qq = new Qq();
		qq.setId(1);
		qq.setQq(123);
		ObjectMapper mapper =new ObjectMapper();
		mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING,false);  
		mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,false);  
		String jsonStr = mapper.writeValueAsString(qq);
		System.out.println(jsonStr);
		ObjectMapper objectMapper2 = new ObjectMapper();  
	    objectMapper2.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING,true);  
	    String jsonStr2 = objectMapper2.writeValueAsString(qq);  
	    System.out.println(jsonStr2);
		ObjectMapper objectMapper3 = new ObjectMapper();  
		objectMapper3.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,true);  
		String jsonStr3 = objectMapper3.writeValueAsString(qq);  
		System.out.println(jsonStr3);
	}
}
