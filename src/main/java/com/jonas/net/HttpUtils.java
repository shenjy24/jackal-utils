package com.jonas.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author shenjy
 * @date 2020/9/2
 * @description Java原生Http工具类
 */
public class HttpUtils {

    public static String doPost(String url, Map<String, String> paramsMap) {
        return doPost(url, buildParams(paramsMap));
    }

    public static String doPost(String httpUrl, String params) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            //设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            //设置读取远程返回的数据时间：30000毫秒
            connection.setReadTimeout(30000);
            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            //connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            connection.connect();
            // 通过连接对象获取一个输出流，写入参数到请求中
            outputStream = connection.getOutputStream();
            outputStream.write(params.getBytes());
            outputStream.flush();
            outputStream.close();
            if (200 == connection.getResponseCode()) {
                inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder content = new StringBuilder();
                String temp = "";
                while (null != (temp = reader.readLine())) {
                    content.append(temp);
                    content.append("\r\n");
                }
                return content.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, inputStream, reader);
        }
        return "";
    }

    public static String doGet(String url, Map<String, String> paramsMap) {
        String params = "";
        if (null != paramsMap && 0 != paramsMap.size()) {
            params = "?" + buildParams(paramsMap);
        }
        return doGet(url + params);
    }

    public static String doGet(String httpUrl) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            //设置读取远程返回的数据时间：30000毫秒
            connection.setReadTimeout(30000);
            connection.connect();
            if (200 == connection.getResponseCode()) {
                inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder content = new StringBuilder();
                String temp = "";
                while (null != (temp = reader.readLine())) {
                    content.append(temp);
                    content.append("\r\n");
                }
                return content.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, inputStream, reader);
        }
        return "";
    }

    private static String buildParams(Map<String, String> params) {
        if (null == params || 0 == params.size()) {
            return "";
        }

        StringBuilder content = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            content.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return content.toString().substring(0, content.length() - 1);
    }

    private static void close(HttpURLConnection connection, InputStream inputStream, BufferedReader reader) {
        try {
            if (null != connection) {
                connection.disconnect();
            }
            if (null != inputStream) {
                inputStream.close();
            }
            if (null != reader) {
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
