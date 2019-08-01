package com.kangswx.springbootmybatisredis.util;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MybatisRedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private String id;
    private RedisTemplate redisTemplate;
        private static final long EXPIRE_TIME_IN_MINUTES = 30; // redis过期时间

    public MybatisRedisCache() {
    }

    public MybatisRedisCache(String id) {
        if(null == id){
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
    }

    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForValue = redisTemplate.opsForValue();
        return opsForValue.get(key);
    }

    @Override
    public Object removeObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.delete(key);
        return null;
    }

    /**
     * Clears this cache instance
     */
    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.execute((RedisCallback) connection -> {
            connection.flushDb();
            return null;
        });
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    public RedisTemplate getRedisTemplate() {
        if(null == redisTemplate){
            redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }
}
