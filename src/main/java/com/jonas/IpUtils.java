package com.jonas;

import com.google.common.collect.Maps;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2019/02/19
 */
public class IpUtils {

    public static String getCityByAmap(String ip) {

        String url = "https://restapi.amap.com/v3/ip";
        String key = "8693365cf148382ff99604caa9326bb6";

        Map<String, Object> params = Maps.newHashMap();
        params.put("key", key);
        params.put("ip", ip);

        Response response = HttpUtils.synGet(url, params);

        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getCityByBaidu(String ip) {

        String url ="https://api.map.baidu.com/location/ip";
        String ak = "pxreFTwdshiVtPuitTnHn1OhAXWGagZ7";

        Map<String, Object> params = Maps.newHashMap();
        params.put("ak", ak);
        params.put("ip", ip);

        Response response = HttpUtils.synGet(url, params);

        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(getCityByAmap("123.139.94.139"));
    }
}
