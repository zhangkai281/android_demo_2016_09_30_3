package com.wuxianedu.a221_http;

import com.wuxianedu.core.utils.L;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caibing.zhang on 2016/8/11.
 */
public class HttpTest extends ApplicationTest{

    public void testHttpGet(){
//        String url  = "http://ip.taobao.com/service/getIpInfo.php?ip=63.223.108.42";
        String url  = "http://ip.taobao.com/service/getIpInfo.php";
        HttpClient httpClient = new DefaultHttpClient();

        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("ip","63.223.108.42"));

        url += "?"+URLEncodedUtils.format(list,"UTF-8");

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

    public void testPost(){
//        String url = "http://git.oschina.net/api/v3/session";
        String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
        HttpClient httpClient = new DefaultHttpClient();

//        String userName = "zhangkai281@sina.com";
//        String pwd = "zhang!@#456";

        List<BasicNameValuePair> list =  new ArrayList<>();
//        BasicNameValuePair basicNameValuePair =new BasicNameValuePair("email",userName);
//        list.add(basicNameValuePair);
//        list.add(new BasicNameValuePair("password",pwd));

        list.add(new BasicNameValuePair("tel","15850781443"));

        HttpPost httpPost =  new HttpPost(url);  //post请求
//        httpPost.addHeader("Accept", "text/html");   //指定客户端能够接收的内容类型
//        httpPost.addHeader("Accept-Charset", "utf-8");  //客户端可以接受的字符编码集。
//        httpPost.addHeader("Accept-Encoding", "gzip");   //指定浏览器可以支持的web服务器返回内容压缩编码类型。
//        httpPost.addHeader("Accept-Language", "en-US,en");
//        httpPost.addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22");

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list,"UTF-8"));  //发送http post，参数，参数编码为UTF-8

            HttpResponse httpResponse = httpClient.execute(httpPost);

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            L.e("----响应状态码---->>:"+statusCode);
            switch (statusCode){
                case 200:
                case 201:
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
