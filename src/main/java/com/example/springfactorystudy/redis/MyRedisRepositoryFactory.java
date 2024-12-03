package com.example.springfactorystudy.redis;

import org.springframework.data.repository.core.EntityInformation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class MyRedisRepositoryFactory extends RepositoryFactorySupport {

    @Override
    public <T, ID> EntityInformation<T, ID> getEntityInformation(Class<T> domainClass) {
        return new MyRedisEntityInformation<>(domainClass);
    }

    @Override
    protected Object getTargetRepository(RepositoryInformation metadata) {
        EntityInformation<?, ?> entityInformation = getEntityInformation(metadata.getDomainType());
        return super.getTargetRepositoryViaReflection(metadata, entityInformation);
//        return new SimpleMyRedisRepository<>();
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return SimpleMyRedisRepository.class;
    }
}
