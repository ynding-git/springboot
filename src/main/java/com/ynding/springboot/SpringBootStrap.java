package com.ynding.springboot;

import com.ynding.springboot.config.TaskThreadPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableCaching
@EnableAsync
@EnableConfigurationProperties({TaskThreadPoolConfig.class})
public class SpringBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStrap.class, args);
    }
 
}