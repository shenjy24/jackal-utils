package com.jonas.nexus;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 本地安装Nexus2，执行 nexus console 启动界面，地址为http://localhost:8081
 * API文档：http://localhost:8081/nexus/nexus-restlet1x-plugin/default/docs/index.html
 */
public class VersionChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(VersionChecker.class);
    private static final String USER = "admin";
    private static final String PWD = "admin123";
    private static final String URL = "http://localhost:8081/nexus/";
    private static final String PATH = "service/local/artifact/maven/resolve";

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
        WebResource service = getService();
        ClientResponse response = service.path(PATH)
                .queryParam("g", groupId).queryParam("a", artifactId).queryParam("v", "RELEASE").queryParam("r", "releases")
                .accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        LOGGER.info("获取远程仓库artifact返回结果:" + response);
        if (200 == response.getStatus()) {
            String json = response.getEntity(String.class);
            LOGGER.info("远程仓库artifact版本信息: " + json);
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            return jsonObject.getAsJsonObject("data");
        } else {
            LOGGER.error("获取远程仓库artifact信息异常");
            return null;
        }
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

    private static WebResource getService() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        client.addFilter(new HTTPBasicAuthFilter(USER, PWD));
        return client.resource(getBaseURI());
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri(URL).build();
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
