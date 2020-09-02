package com.jonas.common;

import com.google.common.collect.Maps;
import com.jonas.net.OkHttpUtils;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * 获取地理定位工具类
 *
 * @author shenjy 2019/02/19
 */
public class GeoUtils {

    /**
     * 通过高德地图API获取IP位置信息
     *
     * @param ip
     * @return
     */
    public static String getGeoByAmap(String ip) {

        String url = "https://restapi.amap.com/v3/ip";
        String key = "8693365cf148382ff99604caa9326bb6";

        Map<String, Object> params = Maps.newHashMap();
        params.put("key", key);
        params.put("ip", ip);

        Response response = OkHttpUtils.synGet(url, params);

        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 通过百度地图API获取IP位置信息
     *
     * @param ip
     * @return
     */
    public static String getGeoByBaidu(String ip) {

        String url ="https://api.map.baidu.com/location/ip";
        String ak = "pxreFTwdshiVtPuitTnHn1OhAXWGagZ7";

        Map<String, Object> params = Maps.newHashMap();
        params.put("ak", ak);
        params.put("ip", ip);

        Response response = OkHttpUtils.synGet(url, params);

        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(getGeoByAmap("123.139.94.139"));
        System.out.println(getGeoByBaidu("123.139.94.139"));
    }
}
