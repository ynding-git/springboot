package com.ynding.springboot;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ynding.springboot.config.TaskThreadPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableScheduling
//@EnableCaching
@EnableAsync
@EnableConfigurationProperties({TaskThreadPoolConfig.class})
public class SpringBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStrap.class, args);
    }

    //让Spring管理JPAQueryFactory
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
 
}