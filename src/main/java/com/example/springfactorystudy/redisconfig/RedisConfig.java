package com.example.springfactorystudy.redisconfig;

import com.example.springfactorystudy.redis.EnableMyRedisRepositories;
import com.example.springfactorystudy.redis.MyRedisTemplate;
import com.example.springfactorystudy.service.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableMyRedisRepositories(basePackages = "com.example.springfactorystudy")
public class RedisConfig {

//    @Bean(name = "redisTemplate")
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        var template = new RedisTemplate<String, String>();

        var myRedisSerializer = new MyRedisSerializer();

        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(myRedisSerializer);
        template.setValueSerializer(myRedisSerializer);
        template.setHashKeySerializer(myRedisSerializer);
        template.setHashValueSerializer(myRedisSerializer);

        return template;
    }

    @Bean
    public MyRedisTemplate myRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new MyRedisTemplate(redisConnectionFactory);
    }
}
