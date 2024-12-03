package com.example.springfactorystudy.service;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("hello")
public class Hello {
    private String id = "1";
    private String name = "mj";
}
