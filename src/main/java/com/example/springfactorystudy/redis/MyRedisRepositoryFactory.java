package com.example.springfactorystudy.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

@RequiredArgsConstructor
public class MyRedisRepositoryFactory extends RepositoryFactorySupport {

    private final MyRedisTemplate myRedisTemplate;

    @Override
    public <T, ID> EntityInformation<T, ID> getEntityInformation(Class<T> domainClass) {
        return new MyRedisEntityInformation<>(domainClass);
    }

    @Override
    protected Object getTargetRepository(RepositoryInformation repositoryInformation) {
//        EntityInformation<?, ?> entityInformation = getEntityInformation(metadata.getDomainType());
//        return super.getTargetRepositoryViaReflection(metadata, entityInformation);
        return new SimpleMyRedisRepository<>(myRedisTemplate, getEntityInformation(repositoryInformation.getDomainType()));
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return SimpleMyRedisRepository.class;
    }
}
