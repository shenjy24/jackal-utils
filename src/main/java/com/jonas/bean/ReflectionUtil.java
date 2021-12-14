package com.jonas.bean;

import lombok.Data;
import org.reflections.Reflections;

/**
 * @author shenjy
 * @date 2021/11/30
 * @description 反射工具类
 */
@Data
public class ReflectionUtil {

    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.jonas");
        System.out.println(reflections.getTypesAnnotatedWith(Data.class));
    }
}
