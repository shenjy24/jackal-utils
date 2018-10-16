package com.jonas;

import com.google.common.base.Charsets;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

/**
 * 【 数字签名工具类 】
 *
 * @author shenjy 2018/10/16
 */
public class SignUtils {

    /**
     * 生成密钥对
     *
     * @return
     */
    public static KeyPair getKeyPair() {
        try {
            KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
            keyGenerator.initialize(1024);
            KeyPair keyPair = keyGenerator.generateKeyPair();
            return keyPair;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用md5生成内容摘要，再用RSA的私钥加密，进而生成数字签名
     *
     * @param content
     * @param privateKey
     * @return
     */
    public static String getMd5Sign(String content, PrivateKey privateKey) {
        try {
            byte[] dataBytes = content.getBytes(Charsets.UTF_8);
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(privateKey);
            signature.update(dataBytes);
            byte[] sign = signature.sign();
            return Base64.getEncoder().encodeToString(sign);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 对用md5和RSA私钥生成的数字签名进行验证
     *
     * @param content
     * @param sign
     * @param publicKey
     * @return
     */
    public static boolean verifyMd5Sign(String content, String sign, PublicKey publicKey) {
        try {
            byte[] dataBytes = content.getBytes(Charsets.UTF_8);
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(publicKey);
            signature.update(dataBytes);
            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 用sha1生成内容摘要，再用RSA的私钥加密，进而生成数字签名
     *
     * @param content
     * @param privateKey
     * @return
     */
    public static String getSha1Sign(String content, PrivateKey privateKey) {
        try {
            byte[] dateBytes = content.getBytes(Charsets.UTF_8);
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initSign(privateKey);
            signature.update(dateBytes);
            byte[] sign = signature.sign();
            return Base64.getEncoder().encodeToString(sign);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 对用md5和RSA私钥生成的数字签名进行验证
     *
     * @param content
     * @param sign
     * @param publicKey
     * @return
     */
    public static boolean verifySha1Sign(String content, String sign, PublicKey publicKey) {
        try {
            byte[] dataBytes = content.getBytes(Charsets.UTF_8);
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(dataBytes);
            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 通过公钥字符串将公钥还原
     *
     * @param publicKey Base64.getEncoder().encodeToString(publicKey.getEncoded()
     * @return
     */
    public static PublicKey getPublicKey(String publicKey) {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey key = keyFactory.generatePublic(keySpec);
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 通过私钥字符串将公钥还原，适用于RSA算法
     *
     * @param privateKey Base64.getEncoder().encodeToString(privateKey.getEncoded())
     * @return
     */
    public static PrivateKey getPrivateKey(String privateKey) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey key = keyFactory.generatePrivate(keySpec);
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 将key排好序，获取将被签名的内容
     *
     * @param sortedParams
     * @return
     */
    public static String getSignContent(Map<String, Object> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = String.valueOf(sortedParams.get(key));
            if (areNotEmpty(key, value)) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }

    /**
     * 检查指定的字符串列表是否不为空。
     */
    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !isEmpty(value);
            }
        }
        return result;
    }

    /**
     * 检查指定的字符串是否为空。
     * <ul>
     * <li>SysUtils.isEmpty(null) = true</li>
     * <li>SysUtils.isEmpty("") = true</li>
     * <li>SysUtils.isEmpty("   ") = true</li>
     * <li>SysUtils.isEmpty("abc") = false</li>
     * </ul>
     *
     * @param value 待检查的字符串
     * @return true/false
     */
    public static boolean isEmpty(String value) {
        int strLen;
        if (value == null || (strLen = value.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(value.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}
