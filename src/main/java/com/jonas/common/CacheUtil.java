package com.jonas.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author shenjy
 * @date 2021/1/6
 * @description 缓存工具类
 */
public class CacheUtil {

    public static <K, V> Cache<K, V> getCache() {
        return getCache(10);
    }

    public static <K, V> Cache<K, V> getCache(int minutes) {
        return CacheBuilder.newBuilder()
                //cache的初始容量
                .initialCapacity(10)
                //cache最大缓存数
                .maximumSize(20)
                //设置写缓存后n分钟过期
                .expireAfterWrite(minutes, TimeUnit.MINUTES)
                //设置读写缓存后n秒钟过期,实际很少用到,类似于expireAfterWrite
                //.expireAfterAccess(17, TimeUnit.SECONDS)
                .build();
    }
}
