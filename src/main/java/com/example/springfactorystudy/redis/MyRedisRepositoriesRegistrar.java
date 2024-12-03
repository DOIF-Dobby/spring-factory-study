package com.example.springfactorystudy.redis;

import java.lang.annotation.Annotation;
import org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

public class MyRedisRepositoriesRegistrar extends RepositoryBeanDefinitionRegistrarSupport {

    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return EnableMyRedisRepositories.class;
    }

    @Override
    protected RepositoryConfigurationExtension getExtension() {
        return new MyRedisRepositoryConfigurationExtension();
    }
}
