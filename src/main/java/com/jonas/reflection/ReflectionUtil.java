package com.jonas.reflection;

import com.jonas.reflection.annotation.MyAnnotation;
import com.jonas.reflection.bean.Person;
import lombok.Data;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.util.Map;

/**
 * @author shenjy
 * @date 2021/11/30
 * @description 反射工具类
 */
@Data
public class ReflectionUtil {

    public static void main(String[] args) {
        testSubTypeOf(Map.class);
        testSubTypeOf(Person.class);
        testTypesAnnotatedWith(MyAnnotation.class);
    }

    /**
     * 获取某个目录下某个类的子类示例
     *
     * @param clazz 类
     */
    public static void testSubTypeOf(Class clazz) {
        ConfigurationBuilder builder = new ConfigurationBuilder().forPackages("com.jonas")
                .addScanners(Scanners.TypesAnnotated).addScanners(Scanners.SubTypes);
        Reflections reflections = new Reflections(builder);
        System.out.println(reflections.getSubTypesOf(clazz));
    }

    /**
     * 获取某个目录下有某个注解的类示例
     *
     * @param clazz 类
     */
    public static void testTypesAnnotatedWith(Class clazz) {
        Reflections reflections = new Reflections("com.jonas");
        // 注解的生命周期必须为CLASS或RUNTIME才能获取到，SOURCE获取不到
        System.out.println(reflections.getTypesAnnotatedWith(clazz));
    }
}
