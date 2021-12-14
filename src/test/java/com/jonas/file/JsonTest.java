package com.jonas.file;

import com.jonas.bean.GsonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author shenjy
 * @date 2020/9/3
 * @description
 */
public class JsonTest {

    @Test
    public void testGson() {
        User user = new User(1, "Tom", new Entity(Arrays.asList("Nice")));
        System.out.println(GsonUtils.toJson(user));
        System.out.println(GsonUtils.toBean(GsonUtils.toJson(user), User.class));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private int id;
        private String name;
        private Entity entity;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Entity {
        private List<String> entities;
    }
}
