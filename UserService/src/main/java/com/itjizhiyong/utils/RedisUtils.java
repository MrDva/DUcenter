package com.itjizhiyong.utils;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 设置超时时间，单位是秒
     * @param key
     * @param time
     * @return
     */
    public  boolean expire(String key,long time){
        try{
            if(time > 0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
                return true;
            }else{
                return false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 获取key的过期时间，单位：秒
     * @param key   key
     * @return  过期时间
     */
    public long getExpireSeconds(String key){

//        System.out.println("redisTemplate.getExpire"+redisTemplate.getExpire(key,TimeUnit.SECONDS));
        if(!this.hasKey(key)) return 0;
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 获取key的过期时间，单位：分钟
     * @param key   key
     * @return  过期时间
     */
    public long getExpireMinutes(String key){
        if (!this.hasKey(key)) return 0;
        return redisTemplate.getExpire(key,TimeUnit.MINUTES);
    }

    /**
     * 获取key的过期时间，单位：小时
     * @param key   key
     * @return  过期时间
     */
    public long getExpireHours(String key){
        if(!this.hasKey(key)) return 0;
        return redisTemplate.getExpire(key,TimeUnit.HOURS);
    }

    /**
     * 获取key的过期时间，单位：天
     * @param key   key
     * @return  过期时间
     */
    public long getExpireDays(String key){
        if(!this.hasKey(key)) return 0;
        return redisTemplate.getExpire(key,TimeUnit.DAYS);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        Boolean result = redisTemplate.hasKey(key);
        System.out.println(result);
        if(result != null)
            return result;
        return result;
    }

    /**
     * 删除一个或多个key
     * @param key
     */
    public void del(String ... key){
        if(key.length < 1){
            new Exception("请输入参数").printStackTrace();
        }else if(key.length > 1){
            redisTemplate.delete(CollectionUtils.arrayToList(key));
        }else{
            redisTemplate.delete(key[0]);
        }
    }
    //************************String*********************************
    /**
     * 获取key的value
     * @param key
     * @return
     */
    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 存入key-value
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){
        try{
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 存放key-value的同时设置过期时间。
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key,Object value,long time){
        try{
            if(time > 0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else{
                redisTemplate.opsForValue().set(key,value);
            }
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 指定key进行自增number
     * @param key  redis中的kye
     * @param number 如果需要传入整数，可以使用new Double();
     * @return  返回自增后的结果，类型为Double
     */
    public Double incr(String key, Double number){
        if(number < 0){
            new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,number);
    }
}
