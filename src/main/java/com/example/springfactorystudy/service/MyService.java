package com.example.springfactorystudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {

    private final HelloRepository helloRepository;

    public void save() {
        System.out.println("Hello");
    }

}
