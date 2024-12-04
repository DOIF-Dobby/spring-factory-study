package com.example.springfactorystudy.service;

import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

@ToString
@RedisHash("redisHashData")
public class RedisHashData {

    private String id = "2";
    private String name = "redisHashData";
}
