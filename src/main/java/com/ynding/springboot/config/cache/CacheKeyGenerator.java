package com.ynding.springboot.config.cache;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author ynding
 * 自定义缓存key
 */
@Component
public class CacheKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return new StringBuilder(method.getName()).append("_").append(Arrays.toString(params));
    }
}
