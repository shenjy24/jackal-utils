package com.jonas.file;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * Yaml解析工具类
 *
 * @author shenjy
 * @version 1.0
 * @date 2020-09-05
 */
public class YamlParser {

    private static final Yaml yaml = new Yaml();

    public static  <T> T toBean(String file, Class<T> clz) {
        ClassLoader classLoader = YamlParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(file);
        return yaml.loadAs(inputStream, clz);
    }
}
