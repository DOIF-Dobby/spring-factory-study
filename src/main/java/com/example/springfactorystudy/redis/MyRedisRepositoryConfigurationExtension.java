package com.example.springfactorystudy.redis;

import java.util.Collection;
import java.util.Collections;
import org.springframework.data.repository.config.RepositoryConfigurationExtensionSupport;

public class MyRedisRepositoryConfigurationExtension extends RepositoryConfigurationExtensionSupport {

    @Override
    public String getModuleName() {
        return "MyRedis";
    }

    @Override
    protected String getModulePrefix() {
        return getModuleIdentifier();
    }

    @Override
    public String getRepositoryFactoryBeanClassName() {
        return MyRedisRepositoryFactoryBean.class.getName();
    }

    @Override
    protected Collection<Class<?>> getIdentifyingTypes() {
        return Collections.singleton(MyRedisRepository.class);
    }
}
