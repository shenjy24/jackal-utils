package com.jonas.set;

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
     * 按照value排序
     * @param map 源map
     * @param asc 是否升序
     * @param <K>
     * @param <V>
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

    public static void main(String[] args) {
        Map<String, Double> source = new LinkedHashMap<String, Double>() {{
            put("Tom", 1.0);
            put("John", 1.3);
            put("Mike", 1.1);
        }};
        Map<String, Double> target = sortMapByValue(source, true);
        System.out.println(source);
        System.out.println(target);
    }
}
