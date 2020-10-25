package com.anue.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
	
	@Autowired
	JedisPool jedisPool;
	
	public String setData(byte[] key, byte[] value) {
		Jedis jedis = null;
	    String result = null;
	    try {
	    	jedis = jedisPool.getResource();
	        result = jedis.set(key, value);
	        jedis.expire(key, 3600);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return result;
	    } finally {
	        release(jedis);
	    }
	    return result;
	}
	
	public byte[] getData(byte[] key) {
		Jedis jedis = null;
	    byte[] result = null;
	    try {
	    	jedis = jedisPool.getResource();
	        result = jedis.get(key);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return result;
	    } finally {
	        release(jedis);
	    }
	    return result;
	}

	public Long delData(byte[] key) {
		Jedis jedis = null;
	    Long result = null;
	    try {
	    	jedis = jedisPool.getResource();
	    	result = jedis.del(key);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return result;
	    } finally {
	        release(jedis);
	    }
	    return result;
	}
	 
	 
    /**
     * 释放Jedis
     */
    protected void release(final Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
	
}
