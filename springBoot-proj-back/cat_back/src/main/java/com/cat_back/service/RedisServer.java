package com.cat_back.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServer {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    public void setValue(String key, String value, long timeout){
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }
    public String getValue(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
    public void delValue(String key){
        stringRedisTemplate.delete(key);
    }

}
