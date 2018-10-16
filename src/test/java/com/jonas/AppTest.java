package com.jonas;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

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
}
