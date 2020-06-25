package com.cooler.ai.platform.service.impl;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2018/12/13
 **/
import com.cooler.ai.platform.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cacheService")
public class CacheServiceImpl<T> implements CacheService<T> {

    @Autowired
    @Qualifier("jedisTemplate")
    public RedisTemplate redisTemplate;

    @Override
    public void setContext(String key, T value) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value);
    }

    /**
     * 获得缓存的基本对象。
     * @param key       缓存键值
     * @return 缓存键值对应的数据
     */
    @Override
    public T getContext(String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 根据key集合，一次获取多个结果
     * @param keys  key集合
     * @return  多个结果
     */
    public List<T> getContextList(List<String> keys) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.multiGet(keys);
    }

}