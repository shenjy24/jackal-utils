package com.jonas.file;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Yaml工具类
 *
 * @author shenjy
 * @version 1.0
 * @date 2020-09-05
 */
public class YamlUtil {

    private static final Yaml yaml = new Yaml();

    public static <T> T toBean(String file, Class<T> clz) {
        ClassLoader classLoader = YamlUtil.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(file);
        return yaml.loadAs(inputStream, clz);
    }

    public static void write(Object data, String filePath) {
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(yaml.dump(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
