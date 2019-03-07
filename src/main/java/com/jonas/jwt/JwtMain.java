package com.jonas.jwt;

import com.nimbusds.jose.JOSEException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2019/03/07
 */
public class JwtMain {

    public static void main(String[] args) throws JOSEException, ParseException {
        Map<String, Object> payload = new HashMap<>();

        //建立载荷，这些数据根据业务，自己定义
        payload.put("uid", 1);
        //生成时间
        payload.put("sta", System.currentTimeMillis());
        //过期时间
        payload.put("exp", System.currentTimeMillis() + 3600);

        String token = JwtUtil.generateToken(payload);
        System.out.println("token=" + token);

        if (null != token) {
            Map<String, Object> result = JwtUtil.validToken(token);
            System.out.println(result);
        }
    }
}
