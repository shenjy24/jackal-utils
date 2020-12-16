package com.jonas.object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * @author shenjy
 * @date 2020/9/3
 * @description
 */
public class JacksonUtils {

    public static void main(String[] args) {
        List<String> commands = Arrays.asList("c:message raw %player% hello", "c:message raw %player% hi");
        String message = toJson(commands);
        System.out.println(message);
        String[] list = toBean(message, String[].class);
        Arrays.stream(list).forEach(System.out::println);
    }

    public static <T> T toBean(String json, Class<T> clz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String toJson(T t) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
