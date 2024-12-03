package com.example.springfactorystudy.service;

import com.example.springfactorystudy.redis.MyRedisRepository;

public interface HelloRepository extends MyRedisRepository<Hello, String> {

}
