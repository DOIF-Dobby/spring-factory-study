package com.example.springfactorystudy.service;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface AbcRepository extends KeyValueRepository<Hello, String> {

}
