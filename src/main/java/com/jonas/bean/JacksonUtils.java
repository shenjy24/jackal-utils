package com.jonas.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenjy
 * @date 2020/9/3
 * @description
 */
public class JacksonUtils {

    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
        String message = toJson(commands);
        System.out.println(message);
        String[] list = toBean(message, String[].class);
        Arrays.stream(list).forEach(System.out::println);
    }

    public static <T> T toBean(String json, Class<T> clz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, clz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String toJson(T t) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
