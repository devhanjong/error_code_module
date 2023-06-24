package kr.co.devhanjong.hj_error_code_module.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

public class RedisUtil {
    @Autowired
    private RedisTemplate<Object,Object>  redisTemplate;

    // Get Data
    public Map<String, Object> getRedisDataMap(String redisKey) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if(Boolean.TRUE.equals(redisTemplate.hasKey(redisKey))) {
                String data = Objects.requireNonNull(redisTemplate.opsForValue().get(redisKey)).toString();
                map = JsonUtil.fromJson(data, new TypeReference<Map<String, Object>>(){});
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public String getRedisDataString(String redisKey) {
        String data = "";
        try {
            if(Boolean.TRUE.equals(redisTemplate.hasKey(redisKey))) {
                data = Objects.requireNonNull(redisTemplate.opsForValue().get(redisKey)).toString();
                System.out.println("data = " + data);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Get List Data
    public List<Map<String, Object>> getRedisDataList(String redisKey) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            if (Boolean.TRUE.equals(redisTemplate.hasKey(redisKey))) {
                String data = Objects.requireNonNull(redisTemplate.opsForValue().get(redisKey)).toString();
                list = JsonUtil.fromJson(data, new TypeReference<List<Map<String, Object>>>() {
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Set Data
    public void setRedisData(String redisKey, String value) {
        try {
            redisTemplate.opsForValue().set(redisKey , value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Data
    public void removeRedisData(String redisKey) {
        redisTemplate.delete(redisKey);
    }
}
