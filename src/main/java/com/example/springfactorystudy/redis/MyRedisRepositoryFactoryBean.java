package com.example.springfactorystudy.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.util.Assert;

public class MyRedisRepositoryFactoryBean<T extends Repository<S, ID>, S, ID> extends RepositoryFactoryBeanSupport<T, S ,ID> {

    private MyRedisTemplate myRedisTemplate;

    public void setMyRedisTemplate(MyRedisTemplate myRedisTemplate) {
        Assert.notNull(myRedisTemplate, "StringRedisTemplate must not be null!");
        this.myRedisTemplate = myRedisTemplate;
    }

    protected MyRedisRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory() {
        return createRepositoryFactory(this.myRedisTemplate);
    }

    protected RepositoryFactorySupport createRepositoryFactory(MyRedisTemplate myRedisTemplate) {
        return new MyRedisRepositoryFactory(myRedisTemplate);
    }
}
