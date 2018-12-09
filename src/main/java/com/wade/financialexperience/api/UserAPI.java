/*
 * Copyright (c)
 * @author: Wade.Ye
 * @email: ye_jianquan@126.com
 * created at 2018/12/9  .
 */

package com.wade.financialexperience.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wade.financialexperience.model.dto.WXUserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author wade.ye
 * @date 18-12-9 下午12:31
 */
@Component
public class UserAPI {
    @Value("${wx.appid}")
    private String appId;
    @Value("${wx.secret}")
    private String secret;
    public  WXUserDTO getUser(String code){
        String url = "https://api.weixin.qq.com/sns/jscode2session" +
                "?appid=" + appId +
                "&secret=" + secret +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        String res = httpsRequest(url,"GET", null);

        return JSON.parseObject(res, new TypeReference<WXUserDTO>(){});
    }
    /*
     * 处理https GET/POST请求
     * 请求地址、请求方法、参数
     * */
    public static String httpsRequest(String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer=null;
        try{
            //创建SSLContext
            SSLContext sslContext= SSLContext.getInstance("SSL");
            //TrustManager[] tm={new MyX509TrustManager()};
            //初始化
            sslContext.init(null, /*tm*/null, new java.security.SecureRandom());;
            //获取SSLSocketFactory对象
            SSLSocketFactory ssf=sslContext.getSocketFactory();
            URL url=new URL(requestUrl);
            HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            //设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            //往服务器端写内容
            if(null!=outputStr){
                OutputStream os=conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
