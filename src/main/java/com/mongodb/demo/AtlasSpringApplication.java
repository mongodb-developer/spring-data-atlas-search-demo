package com.mongodb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AtlasSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtlasSpringApplication.class, args);
    }

}
