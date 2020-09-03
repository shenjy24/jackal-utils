package com.jonas.net;

import org.junit.Test;

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
}
