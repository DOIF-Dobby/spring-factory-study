package com.example.springfactorystudy.redis;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.core.EntityInformation;

@RequiredArgsConstructor
public class SimpleMyRedisRepository<T, ID> implements MyRedisRepository<T, ID>{

    private final MyRedisTemplate myRedisTemplate;
    private final EntityInformation<T, ID> entityInformation;

    @Override
    public void save(T entity) {
        var id = entityInformation.getId(entity);

        if (id == null) {
            throw new RuntimeException("id is null");
        }

        myRedisTemplate.set(id.toString(), entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        var entity = myRedisTemplate.get(getKey(id), entityInformation.getJavaType());
        return Optional.ofNullable(entity);
    }

    private String getKey(ID id) {
        var entityType = entityInformation.getJavaType();
        var annotation = entityType.getAnnotation(RedisString.class);
        if (annotation == null) {
            throw new RuntimeException("RedisString annotation not found");
        }

        var keyPrefix = annotation.value();

        return String.format("%s:%s", keyPrefix, id);
    }
}
