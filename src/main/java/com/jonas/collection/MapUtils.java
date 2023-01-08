package com.jonas.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.*;

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

    /**
     * 按照key排序
     *
     * @param map 源map
     * @param asc 是否升序
     * @return
     */
    public static <K extends Comparable, V> Map<K, V> sortMapByKey(Map<K, V> map, boolean asc) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());

        if (asc) {
            Collections.sort(list, Comparator.comparing(Map.Entry::getKey));
        } else {
            Collections.sort(list, (o1, o2) -> o2.getKey().compareTo(o1.getKey()));
        }

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    /**
     * 按照value排序
     *
     * @param map 源map
     * @param asc 是否升序
     * @return
     */
    public static <K, V extends Comparable> Map<K, V> sortMapByValue(Map<K, V> map, boolean asc) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());

        if (asc) {
            Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        } else {
            Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        }

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
