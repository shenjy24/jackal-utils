package com.jonas.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenjy
 * @date 2021/1/6
 * @description
 */
public class MapTest {

    @Test
    public void testSortByKey() {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "2");
        map.put(1, "1");
        map.put(3, "3");
        Map<Integer, String> sortedMap = MapUtils.sortMapByKey(map, false);
        System.out.println(sortedMap);
    }
}
