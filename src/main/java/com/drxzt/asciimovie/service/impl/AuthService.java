package com.drxzt.asciimovie.service.impl;

/**
 * className AuthService
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/6/1 16:49
 */

import com.drxzt.asciimovie.dao.TokenDoMapper;
import com.drxzt.asciimovie.entities.TokenDo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static com.drxzt.asciimovie.commous.Constants.CLIENT_ID;
import static com.drxzt.asciimovie.commous.Constants.CLIENT_SECRET;

/**
 * 获取token类
 */
@Component
@Configurable
@EnableScheduling
public class AuthService {

    @Autowired
    TokenDoMapper tokenDoMapper;

    @Scheduled(cron = "0 15 10 ? * MON")
    public void  getAuth() {
        System.out.println("更新百度TOKEN");
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + CLIENT_ID
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + CLIENT_SECRET;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            JSONObject jsonObject = new JSONObject(result);
            TokenDo tokenDo=tokenDoMapper.selectByPrimaryKey(1);
            tokenDo.setAccessToken(jsonObject.getString("access_token"));
            tokenDoMapper.updateByPrimaryKeySelective(tokenDo);
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
    }

}