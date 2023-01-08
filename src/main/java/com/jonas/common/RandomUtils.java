package com.jonas.common;

import java.util.Random;

/**
 * 随机数工具
 */
public class RandomUtils {

    private static final Random random = new Random();

    /**
     * 获取区间[start, end]的随机数
     *
     * @param begin 起始值
     * @param end   截止值
     * @return 随机数
     */
    public static int nextInt(int begin, int end) {
        return (int) Math.floor(Math.random() * (end - begin + 1) + begin);
    }

    /**
     * 获取区间[start, end]的随机数
     *
     * @param begin 起始值
     * @param end   截止值
     * @return 随机数
     */
    public static int randomInt(int begin, int end) {
        return random.nextInt(end - begin + 1) + begin;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(randomInt(1, 3));
        }
    }
}
