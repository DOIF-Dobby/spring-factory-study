package com.example.springfactorystudy.service;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface MyKeyValueRepository extends KeyValueRepository<RedisHashData, String> {

}
