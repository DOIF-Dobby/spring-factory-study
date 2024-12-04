package com.example.springfactorystudy.service;

import com.example.springfactorystudy.redis.MyRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {

    private final HelloRepository repository;

    public void save() {
        System.out.println("MyService.save");
        System.out.println("repository = " + repository);
        repository.save(new Hello());
    }

}
