package com.jonas.object;

import lombok.Data;
import org.apache.commons.lang3.ClassPathUtils;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

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
