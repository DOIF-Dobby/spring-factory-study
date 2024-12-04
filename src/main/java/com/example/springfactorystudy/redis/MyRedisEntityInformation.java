package com.example.springfactorystudy.redis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.data.repository.core.support.AbstractEntityInformation;

public class MyRedisEntityInformation<T, ID> extends AbstractEntityInformation<T, ID> {

    public MyRedisEntityInformation(Class<T> domainClass) {
        super(domainClass);
    }

    @Override
    public ID getId(T entity) {
        var entityType = getJavaType();

        var annotation = entityType.getAnnotation(RedisString.class);

        if (annotation == null) {
            throw new RuntimeException("RedisString annotation not found");
        }

        var keyPrefix = annotation.value();
        if (keyPrefix.isBlank()) {
            throw new RuntimeException("keyPrefix is blank");
        }

        var idField = Arrays.stream(entityType.getDeclaredFields())
            .filter(field -> field.isAnnotationPresent(RedisId.class))
            .findFirst()
            .orElseThrow();

        try {
            idField.setAccessible(true);
            var id = idField.get(entity);
            if (id == null) {
                throw new RuntimeException("id is null");
            }

            return (ID) String.format("%s:%s", keyPrefix, id);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Class<ID> getIdType() {
        System.out.println("MyRedisEntityInformation.getIdType");
        return null;
    }
}
