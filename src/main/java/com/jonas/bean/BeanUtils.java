package com.jonas.bean;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * 【 Bean属性复制工具类 】
 *
 * @author shenjy 2019/05/17
 */
public class BeanUtils {

    public static <T> T mapToBean(Map<String, Object> map, Class<T> clz) {
        T t = null;
        try {
            t = clz.newInstance();
            for (Field field : clz.getDeclaredFields()) {
                if (map.containsKey(field.getName())) {
                    boolean flag = field.isAccessible();
                    field.setAccessible(true);
                    Object object = map.get(field.getName());
                    if (object != null && field.getType().isAssignableFrom(object.getClass())) {
                        field.set(t, object);
                    }
                    field.setAccessible(flag);
                }
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 复制对象列表属性
     *
     * @param source
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(List source, Class<T> clazz) {
        List<T> target = JSON.parseArray(JSON.toJSONString(source), clazz);
        return target;
    }

    /**
     * 深克隆
     *
     * @param source
     * @param <T>
     * @return
     */
    public static <T extends Serializable> T deepClone(T source) {
        return ObjectUtil.cloneByStream(source);
    }
}
