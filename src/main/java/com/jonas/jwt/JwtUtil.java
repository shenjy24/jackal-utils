package com.jonas.jwt;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import net.minidev.json.JSONObject;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT(JSON WEB TOKEN) 工具
 *
 * @author shenjy 2019/03/07
 */
public class JwtUtil {

    private static final byte[] secret = "geiwodiangasfdjsikolkjikolkijswe".getBytes();

    /**
     * HS256 对称加密
     *
     * @param payloadMap
     * @return
     */
    public static String generateToken(Map<String, Object> payloadMap) throws JOSEException {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
        Payload payload = new Payload(new JSONObject(payloadMap));
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        JWSSigner jwsSigner = new MACSigner(secret);
        jwsObject.sign(jwsSigner);

        return jwsObject.serialize();
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     * @throws ParseException
     * @throws JOSEException
     */
    public static Map<String, Object> validToken(String token) throws ParseException, JOSEException {
        JWSObject jwsObject = JWSObject.parse(token);
        Payload payload = jwsObject.getPayload();
        JWSVerifier jwsVerifier = new MACVerifier(secret);

        Map<String, Object> resultMap = new HashMap<>();
        if (jwsObject.verify(jwsVerifier)) {
            JSONObject jsonObject = payload.toJSONObject();
            //判断token是否过期
            if (jsonObject.containsKey("exp")) {
                Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                Long nowTime = System.currentTimeMillis();
                if (nowTime > expTime) {
                    resultMap.clear();
                    resultMap.put("message", "token失效");
                }
            }

            resultMap.put("message", "token有效");
            resultMap.put("data", jsonObject);
        } else {
            resultMap.put("message", "token验证失败");
        }

        return resultMap;
    }
}
