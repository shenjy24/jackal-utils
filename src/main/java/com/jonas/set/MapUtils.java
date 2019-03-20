package com.jonas.set;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Map;

/**
 * Map工具类
 *
 * @author shenjy 2019/03/20
 */
public class MapUtils {

    /**
     * 通过value获取key
     *
     * @param map
     * @param value
     * @param <T>
     * @return
     */
    public static <T> T getKeyByValue(Map<?, ?> map, Object value) {
        BiMap<?, ?> biMap = HashBiMap.create(map);
        Object key = biMap.inverse().get(value);
        return (T) key;
    }
}
