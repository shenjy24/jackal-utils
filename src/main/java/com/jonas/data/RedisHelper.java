package com.jonas.data;

import org.apache.commons.lang3.RandomUtils;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author shenjy
 * @date 2020/7/8
 * @description
 */
public class RedisHelper {
    private static Pool<Jedis> redisPool;
    private static final int DB = 5;

    public static void init(Pool<Jedis> pool) {
        redisPool = pool;
    }

    public static String lock(String key, int tryTime) {
        try {
            for (int i = 0; i < tryTime; i++) {
                String lockId = tryLock(key);
                if (null != lockId) {
                    return lockId;
                }
                TimeUnit.MILLISECONDS.sleep(RandomUtils.nextInt(1, 500));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static String tryLock(String key) {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
            if (DB != jedis.getDB()) {
                jedis.select(DB);
            }

            //锁id（必须拥有此id才能释放锁）
            String lockId = UUID.randomUUID().toString();
            String isSuccess = jedis.set(key, lockId, "NX", "PX", 5000);
            if ("OK".equalsIgnoreCase(isSuccess)) {
                return lockId;
            }
            return null;
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public static void unlock(String key, String lockId) {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
            if (DB != jedis.getDB()) {
                jedis.select(DB);
            }

            //执行Lua代码删除lockId匹配的锁, Lua脚本具体原子性
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            jedis.eval(script, Collections.singletonList(key), Collections.singletonList(lockId));
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public static void delZSet(String key) {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
            if (DB != jedis.getDB()) {
                jedis.select(DB);
            }
            jedis.del(key);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public static void setZSet(String key, Map<String /* member */, Integer /* score */> args) {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
            if (DB != jedis.getDB()) {
                jedis.select(DB);
            }
            for (Map.Entry<String, Integer> entry : args.entrySet()) {
                jedis.zincrby(key, entry.getValue(), entry.getKey());
            }
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public static Set<String> getZSet(String key, int len) {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
            if (DB != jedis.getDB()) {
                jedis.select(DB);
            }
            return jedis.zrange(key, 0, len);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public static void setHash(String key, Map<String /* field */, String /* value */> args) {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
            if (DB != jedis.getDB()) {
                jedis.select(DB);
            }

            for (Map.Entry<String, String> entry : args.entrySet()) {
                jedis.hset(key, entry.getKey(), entry.getValue());
            }
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public static String getHash(String key, String field) {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
            if (DB != jedis.getDB()) {
                jedis.select(DB);
            }

            return jedis.hget(key, field);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public static void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
            if (DB != jedis.getDB()) {
                jedis.select(DB);
            }
            jedis.set(key, value);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public static String get(String key) {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
            if (DB != jedis.getDB()) {
                jedis.select(DB);
            }
            return jedis.get(key);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }
}
