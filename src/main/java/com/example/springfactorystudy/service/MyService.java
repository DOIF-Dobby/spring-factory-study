package com.example.springfactorystudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {

    private final AbcRepository repository;

    public void save() {
        repository.save(new Hello());
    }

}
