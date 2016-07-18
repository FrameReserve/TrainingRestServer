package com.training.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * Created by Athos on 2016-07-18.
 */
@RunWith(JUnit4.class)
public class HttpClientTest {
    @Test
    public void doHttpSend() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:8080/securityException/authenticationException");
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(50)
                .setConnectTimeout(50)
                .setSocketTimeout(50).build();
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println("StatusCode -> " + response.getStatusLine().getStatusCode());

//        HttpEntity entity = response.getEntity();
//        String jsonStr = EntityUtils.toString(entity);//, "utf-8");
//        System.out.println(jsonStr);

        httpGet.releaseConnection();
    }
}
