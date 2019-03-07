package com.jonas.shorturl;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 短链接生成还原工具
 *
 * @author shenjy 2019/01/02
 */
public class ShortUrlUtils {

    final static String CREATE_API = "https://dwz.cn/admin/v2/create";

    final static String TOKEN = "978b0159707b85905b07988cebb1a865";

    /**
     * 创建短链
     *
     * @param longUrl
     * @return
     */
    public static String createShortUrl(String longUrl) {

        String params = "{\"url\":\"" + longUrl + "\"}";

        BufferedReader reader = null;
        try {
            // 创建连接
            URL url = new URL(CREATE_API);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            // 设置请求方式
            connection.setRequestMethod("POST");
            // 设置发送数据的格式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Token", TOKEN);

            // 发起请求
            connection.connect();
            // utf-8编码
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            out.append(params);
            out.flush();
            out.close();

            // 读取响应
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            String res = "";
            while ((line = reader.readLine()) != null) {
                res += line;
            }
            reader.close();

            // 抽取生成短网址
            UrlResponse urlResponse = JSON.parseObject(res, UrlResponse.class);
            if (urlResponse.getCode() == 0) {
                return urlResponse.getShortUrl();
            } else {
                System.out.println(urlResponse.getErrMsg());
            }

            return "";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        String res = createShortUrl("https://www.baidu.com");
        System.out.println(res);
    }
}
