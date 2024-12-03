package com.example.springfactorystudy.redis;

import org.springframework.data.repository.core.support.AbstractEntityInformation;

public class MyRedisEntityInformation<T, ID> extends AbstractEntityInformation<T, ID> {

    public MyRedisEntityInformation(Class<T> domainClass) {
        super(domainClass);
    }

    @Override
    public ID getId(T entity) {
        return null;
    }

    @Override
    public Class<ID> getIdType() {
        return null;
    }
}
