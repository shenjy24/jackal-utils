package com.jonas.common.id;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shenjy
 * @createTime 2022/2/24 13:41
 * @description Main
 */
public class Main {

    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator(5, 5);
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            long id = idGenerator.nextId();
            if (set.contains(id)) {
                System.err.println("存在重复ID:" + id);
            } else {
                set.add(id);
                //System.out.println(id);
            }
        }
    }
}
