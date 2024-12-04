package com.example.springfactorystudy;

import com.example.springfactorystudy.redis.EnableMyRedisRepositories;
import com.example.springfactorystudy.service.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableMyRedisRepositories
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
        };
    }
}
