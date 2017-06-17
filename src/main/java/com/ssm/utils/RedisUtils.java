package com.ssm.utils;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;

import javax.json.Json;
import javax.json.JsonArray;
import java.io.Serializable;
import java.util.*;

/**
 * redis cache 工具类
 *
 */
public final  class RedisUtils extends  RedisProvider{

    private static final Logger logger = LogManager.getLogger(RedisUtils.class.getName());

    public  static int  EXPIRE = 5000;


    /**
     * Get the value of the specified key.
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        close(jedis);
        return  value;
    }

    /**
     * Set the string value as value of the key. Default settings at save
     * time(2000s)
     *
     * @param key
     * @param value
     * @return
     */
    public static void set(String key, String value) {
        Jedis jedis = getJedis();
        jedis.setex(key, 2000, value);
        close(jedis);
    }

    /**
     * 获取对象.
     *
     * @param key
     * @return
     */
    public static  <T> T  get(String key,Class<T> clazz){
        return JSON.parseObject(get(key),clazz);
    }



    public static void set(String key, Object obj) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key,JSON.toJSONString(obj));
            jedis.expire(key, EXPIRE);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            close(jedis);
        }
    }






}
