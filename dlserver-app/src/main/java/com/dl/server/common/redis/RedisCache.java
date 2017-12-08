package com.dl.server.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.dl.server.entity.DLEntity;
import com.google.gson.Gson;

//封装redis的操作，捕获RedisConnectionFailureException,保证redis异常状态下不影响正常的业务流程 
public class RedisCache {

    private static Logger log = LoggerFactory.getLogger(RedisCache.class);
    private static StringRedisTemplate stringRedis;

    public static StringRedisTemplate getStringRedis() {
        return stringRedis;
    }

    public void setStringRedis(StringRedisTemplate template) {
        stringRedis = template;
    }

    //缓存数据
    public static void cache(DLEntity entity){
        if(entity.hasId()){
            cache(entity.getEntityKey(), new Gson().toJson(entity));
        }
    }
    
    public static void cache(String key, String value){
        try{
            getStringRedis().opsForValue().set(key, value);
        }catch(RedisConnectionFailureException e){
            log.warn("redis连接失败，请检查redis是否正常:" + e.getMessage());
        }
    }
    
    public static String get(String key){
        String val = null;
        try{
            val = getStringRedis().opsForValue().get(key);
        }catch(RedisConnectionFailureException e){
            log.warn("redis连接失败，请检查redis是否正常:" + e.getMessage());
        }
        return val;
    }
    
    //从缓存获取数据
    public static <T> T get(String key, Class<T> clz){
        String json = get(key);
        if(json == null || json.equals("")){
            return null;
        }
        return new Gson().fromJson(json, clz);
    }
    
    //更新缓存
    public static void update(DLEntity entity){
        if(entity.hasId()){
            cache(entity);
        }
    }
    
    //删除缓存
    public static void delete(String key){
        try{
            getStringRedis().delete(key);
        }catch(RedisConnectionFailureException e){
            log.warn("redis连接失败，请检查redis是否正常:" + e.getMessage());
        }
    }
}
