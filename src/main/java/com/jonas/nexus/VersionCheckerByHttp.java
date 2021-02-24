package com.jonas.nexus;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jonas.net.HttpUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class VersionCheckerByHttp {

    private static final Logger LOGGER = LoggerFactory.getLogger(VersionCheckerByHttp.class);
    private static final String USER = "admin";
    private static final String PWD = "admin123";
    private static final String URL = "http://localhost:8081/nexus/service/local/artifact/maven/resolve";

    public static boolean isLatestVersion(String file) {
        Gav gav = getArtifactGav(file);
        if (null == gav) {
            return false;
        }
        JsonObject latestInfo = getArtifactLatestInfo(gav.groupId, gav.artifactId);
        if (null == latestInfo) {
            return false;
        }
        String latestVersion = null != latestInfo.get("version") ? latestInfo.get("version").getAsString() : "";
        return latestVersion.equals(gav.getVersion());
    }

    private static JsonObject getArtifactLatestInfo(String groupId, String artifactId) {
        Map<String, String> args = new HashMap<String, String>() {{
            put("g", groupId);
            put("a", artifactId);
            put("v", "RELEASE");
            put("r", "releases");
        }};
        String response = doGet(URL, args);
        if (StringUtils.isNotBlank(response)) {
            JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
            return jsonObject.getAsJsonObject("data");
        }
        return null;
    }

    private static Gav getArtifactGav(String file) {
        try {
            JarFile jarFile = new JarFile(file);
            Enumeration<JarEntry> enumeration = jarFile.entries();
            while (enumeration.hasMoreElements()) {
                JarEntry jarEntry = enumeration.nextElement();
                if (jarEntry.getName().contains("pom.properties")) {
                    Properties properties = new Properties();
                    properties.load(jarFile.getInputStream(jarEntry));
                    LOGGER.info("本地artifact版本信息: " + properties);
                    String groupId = properties.getProperty("groupId");
                    String artifactId = properties.getProperty("artifactId");
                    String version = properties.getProperty("version");
                    if (null != groupId && null != artifactId && null != version) {
                        return new Gav(groupId, artifactId, version);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.error("获取本地artifact版本信息异常: " + file);
        return null;
    }

    private static String doGet(String url, Map<String, String> paramsMap) {
        String params = "";
        if (null != paramsMap && 0 != paramsMap.size()) {
            params = "?" + buildParams(paramsMap);
        }
        return doGet(url + params);
    }

    private static String doGet(String httpUrl) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            java.net.URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //设置连接主机服务器的超时时间：5000毫秒
            connection.setConnectTimeout(5000);
            //设置读取远程返回的数据时间：5000毫秒
            connection.setReadTimeout(5000);
            //设置授权信息
            connection.setRequestProperty("Authorization", getAuth(USER, PWD));
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();
            LOGGER.info("获取远程仓库artifact返回结果: " + connection.getResponseCode() + "-" + connection.getResponseMessage());
            if (200 == connection.getResponseCode()) {
                inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder content = new StringBuilder();
                String temp = "";
                while (null != (temp = reader.readLine())) {
                    content.append(temp);
                    content.append("\r\n");
                }
                return content.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, inputStream, reader);
        }
        return "";
    }

    private static String buildParams(Map<String, String> params) {
        if (null == params || 0 == params.size()) {
            return "";
        }

        StringBuilder content = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            content.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return content.substring(0, content.length() - 1);
    }

    private static void close(HttpURLConnection connection, InputStream inputStream, BufferedReader reader) {
        try {
            if (null != connection) {
                connection.disconnect();
            }
            if (null != inputStream) {
                inputStream.close();
            }
            if (null != reader) {
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getAuth(String username, String pwd) {
        final byte[] prefix = (username + ":").getBytes(StandardCharsets.ISO_8859_1);
        final byte[] password = pwd.getBytes(StandardCharsets.ISO_8859_1);
        final byte[] usernamePassword = new byte[prefix.length + password.length];

        System.arraycopy(prefix, 0, usernamePassword, 0, prefix.length);
        System.arraycopy(password, 0, usernamePassword, prefix.length, password.length);

        String authentication = "Basic " + new String(Base64.encode(usernamePassword), StandardCharsets.US_ASCII);
        return authentication;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Gav {
        private String groupId;
        private String artifactId;
        private String version;
    }
}
