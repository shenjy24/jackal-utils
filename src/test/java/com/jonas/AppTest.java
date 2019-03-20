package com.jonas;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.jonas.security.AesUtils;
import com.jonas.security.MD5Utils;
import com.jonas.security.SignUtils;
import org.junit.Assert;
import org.junit.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testDuration() {
        int duration = 3600;
        String str = FormatUtils.formatDuration(duration);
        System.out.println(str);
    }

    @Test
    public void testMD5() {
        String pwd = "1234567";
        String md5Pwd = "05d55d438b6c11083f29f94505a241f1888dd3049f985f05";
        Assert.assertTrue(MD5Utils.verifySaltMd5(pwd, md5Pwd));
    }

    @Test
    public void testAes() {
        String content = "{\"name\" : \"Tom\"}";
        String password = "123456";

        //加密
        System.out.println("加密前：" + JSON.toJSONString(content));
        String encryptResult = AesUtils.encrypt(content, password);
        System.out.println("加密后：" + encryptResult);
        //解密
        String decryptResult = AesUtils.decrypt(encryptResult, password);
        System.out.println("解密后：" + decryptResult);
    }

    @Test
    public void testSign() {
        String data = "study hard and make progress everyday";
        System.out.println("content :" + data);

        /** 获取公钥密钥 */
        KeyPair keyPair = SignUtils.getKeyPair();
        PublicKey publicKey =  keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

//        System.out.println(publicKey);
//        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
//        System.out.println(publicKeyString);
//        System.out.println(SignUtils.getPublicKey(publicKeyString));
//
//        System.out.println(privateKey);
//        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
//        System.out.println(privateKeyString);
//        System.out.println(SignUtils.getPrivateKey(privateKeyString));

        /** MD5签名 */
        String md5Sign = SignUtils.getMd5Sign(data, privateKey);
        System.out.println("sign with md5 and rsa: " + md5Sign);
        boolean md5Verify = SignUtils.verifyMd5Sign(data, md5Sign, publicKey);
        System.out.println("verify sign with md5 and rsa: " + md5Verify);

        /** sha1签名 */
        String sha1Sign  = SignUtils.getSha1Sign(data, privateKey);
        System.out.println("sign with sha1 and rsa: "+ sha1Sign);
        boolean sha1Verify = SignUtils.verifySha1Sign(data, sha1Sign,publicKey);
        System.out.println("verify sign with sha1 and rsa: "+ sha1Verify);

        /** 按照内容排序 */
        Map<String, Object> params = Maps.newHashMap();
        params.put("name", "jonas");
        params.put("age", "20");
        Map<String, String> hobbyMap = Maps.newHashMap();
        hobbyMap.put("one", "soccer");
        hobbyMap.put("two", "basketball");
        params.put("hobby", JSON.toJSONString(hobbyMap));

        String content = SignUtils.getSignContent(params);
        String contentMd5Sign = SignUtils.getMd5Sign(content, privateKey);
        System.out.println("verify sign with md5 and rsa: " + SignUtils.verifyMd5Sign(content, contentMd5Sign, publicKey));
    }

    @Test
    public void testZip() {
        String dir = "/Users/shenjy/Downloads";
        String zipPath = "/Users/shenjy/download.zip";
        CompressUtils.zip(dir, zipPath);

        String unzipDir = "/Users/shenjy/Desktop/temp";
        String unzipFile = "/Users/shenjy/download.zip";
        CompressUtils.unzip(unzipFile, unzipDir);

        System.out.println("success!");
    }
}
