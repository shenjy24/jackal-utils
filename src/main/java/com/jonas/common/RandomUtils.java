package com.jonas.common;

import java.util.Random;

/**
 * 随机数工具
 */
public class RandomUtils {

    private static Random random = new Random();

    /**
     * 获取区间[start, end]的随机数
     *
     * @param start 起始值
     * @param end   截止值
     * @return 随机数
     */
    public static int nextInt(int start, int end) {
        return (int) Math.floor(Math.random() * (end - start + 1) + start);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(nextInt(1, 3));
        }
    }
}
