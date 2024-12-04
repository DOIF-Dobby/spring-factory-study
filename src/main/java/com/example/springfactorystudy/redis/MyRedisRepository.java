package com.example.springfactorystudy.redis;

import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface MyRedisRepository<T, ID> extends Repository<T, ID> {

    void save(T entity);

    Optional<T> findById(ID id);
}
