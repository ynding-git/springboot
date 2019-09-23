package com.ynding.springboot.config;

import com.ynding.springboot.interceptor.UserTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@Primary
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getUserInterceptor())
                .excludePathPatterns(getExcludePathPatterns())
                .addPathPatterns(getIncludePathPatterns());
    }

    @Bean
    UserTokenInterceptor getUserInterceptor() {
        return new UserTokenInterceptor();
    }


    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/**",
        };
        Collections.addAll(list, urls);
        return list;
    }

    private ArrayList<String> getExcludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/error",
                "/v2/**",
                "/swagger-resources/**",
        };
        Collections.addAll(list, urls);
        return list;
    }

}
