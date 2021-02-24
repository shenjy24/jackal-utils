package com.jonas.net;

import com.jonas.object.JacksonUtils;
import okhttp3.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenjy
 * @date 2020/9/2
 * @description
 */
public class HttpTest {

    @Test
    public void testGet() {
        String params = "gameServer=1&gameMode=1&roleId=1";
        String content = HttpUtils.doPost("http://localhost:8080/hyt/getPeak", params);
        System.out.println(content);
    }

    @Test
    public void testPost() {
        String url = "http://10.82.125.10:11111";
        Map<String, Object> args = new HashMap<String, Object>() {{
            put("api", "popo");
            put("message", "test");
            put("group", "hyt_restart");
        }};
        Response response = OkHttpUtils.synPost(url, JacksonUtils.toJson(args));
        System.out.println(response);
    }
}
