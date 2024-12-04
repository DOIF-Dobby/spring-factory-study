package com.example.springfactorystudy.service;

import com.example.springfactorystudy.redis.RedisId;
import com.example.springfactorystudy.redis.RedisString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@RedisString("going")
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hello {
    @RedisId
    private String id;
    private String name;
}
