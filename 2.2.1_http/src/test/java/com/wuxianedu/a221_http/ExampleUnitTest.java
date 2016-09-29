package com.wuxianedu.a221_http;

import com.wuxianedu.core.utils.L;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void get(){
//        String url  = "http://ip.taobao.com/service/getIpInfo.php?ip=63.223.108.42";
        String url  = "http://ip.taobao.com/service/getIpInfo.php";
        HttpClient httpClient = new DefaultHttpClient();

        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("ip","63.223.108.42"));

        url += URLEncodedUtils.format(list,"UTF-8");
        HttpGet httpGet = new HttpGet(url);

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            L.e("----响应状态码---->>:"+statusCode);
            switch (statusCode){
                case 200:
                    HttpEntity httpEntity = httpResponse.getEntity();   //服务器返回的内容
                    String responseMessage = EntityUtils.toString(httpEntity, "UTF-8");   //返回内容进行UTF-8编码
                    L.e("----响应内容---->>:"+responseMessage);
                    break;
                case 404:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}