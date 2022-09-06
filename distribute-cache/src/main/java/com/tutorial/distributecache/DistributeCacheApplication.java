package com.tutorial.distributecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DistributeCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeCacheApplication.class, args);
    }

}
