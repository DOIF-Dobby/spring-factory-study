package com.example.springfactorystudy.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

public class MyRedisTemplate {

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    public MyRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        this.redisTemplate = new StringRedisTemplate(redisConnectionFactory);

        var mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        this.objectMapper = mapper;
    }

    public void set(String key, Object value) {
        var json = serialize(value);
        redisTemplate.opsForValue().set(key, json);
    }

    public <T, ID> T get(ID key, Class<T> classType) {
        var json = redisTemplate.opsForValue().get(key);

        if (json == null) {
            return null;
        }

        return deserialize(json, classType);
    }

    private String serialize(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T deserialize(String json, Class<T> classType) {
        try {
            return objectMapper.readValue(json, classType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
