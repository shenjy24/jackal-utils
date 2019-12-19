package com.jonas.object;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;

/**
 * 【 Bean属性复制工具类 】
 *
 * @author shenjy 2019/05/17
 */
public class BeanCopier {

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
