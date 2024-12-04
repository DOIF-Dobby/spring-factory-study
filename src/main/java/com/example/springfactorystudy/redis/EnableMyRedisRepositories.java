package com.example.springfactorystudy.redis;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.repository.support.RedisRepositoryFactoryBean;
import org.springframework.data.repository.config.DefaultRepositoryBaseClass;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(MyRedisRepositoriesRegistrar.class)
public @interface EnableMyRedisRepositories {

    String[] value() default {};

    String[] basePackages() default {};

    Class<?>[] basePackageClasses() default {};

    Filter[] excludeFilters() default {};

    Filter[] includeFilters() default {};

    Class<?> repositoryFactoryBeanClass() default MyRedisRepositoryFactoryBean.class;

    String namedQueriesLocation() default "";

    String repositoryImplementationPostfix() default "Impl";

    Class<?> repositoryBaseClass() default DefaultRepositoryBaseClass.class;

    Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;
}
