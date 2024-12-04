package com.example.springfactorystudy.redis;

public class SimpleMyRedisRepository<T, ID> implements MyRedisRepository<T, ID>{

    @Override
    public void save(T entity) {
        System.out.println("SimpleMyRedisRepository.save");
        System.out.println("save entity: " + entity);
    }
}
