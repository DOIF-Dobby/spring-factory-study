package com.example.springfactorystudy;

import com.example.springfactorystudy.redis.EnableMyRedisRepositories;
import com.example.springfactorystudy.redis.MyRedisRepositoryFactoryBean;
import com.example.springfactorystudy.service.Hello;
import com.example.springfactorystudy.service.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
public class SpringFactoryStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFactoryStudyApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner(MyService myService) {
        return args -> {
            System.out.println(" runner ");
            myService.save();

            var hello = myService.find();
            System.out.println("hello = " + hello);
        };
    }
}
