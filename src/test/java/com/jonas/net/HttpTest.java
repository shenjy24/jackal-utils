package com.jonas.net;

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
        Map<String, String> params = new HashMap<>();
        params.put("gameServer", "1");
        params.put("gameMode", "1");
        params.put("roleId", "9f31333c-7461-38f7-9cc9-5c2a7843c5c4");
        String content = HttpUtils.doPost("http://localhost:8080/hyt/getPeak", params);
        System.out.println(content);
    }
}
