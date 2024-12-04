package com.example.springfactorystudy.redisconfig;

import com.example.springfactorystudy.redis.EnableMyRedisRepositories;
import com.example.springfactorystudy.service.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

//@Configuration
//@EnableMyRedisRepositories
//@EnableRedisRepositories(
//    redisTemplateRef = "redisTemplate",
//    keyValueTemplateRef = "redisTemplate" // 전혀 영향이 없네
//)
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
    public CommandLineRunner runner(MyService myService) {
        return args -> {
            System.out.println(" runner ");
            myService.save();
        };
    }


}
