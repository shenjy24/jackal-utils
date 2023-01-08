package com.jonas.file;

import lombok.Data;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * YamlTest
 *
 * @author shenjy
 * @version 1.0
 * @date 2020-09-05
 */
public class YamlTest {

    @Test
    public void testParseYaml() {
        TestEntity testEntity = YamlUtil.toBean("config.yml", TestEntity.class);
        System.out.println(testEntity);
    }

    @Data
    public static class TestEntity {
        private Integer key1;
        private List<String> key2;
        private Map<String, String> key3;
    }
}
