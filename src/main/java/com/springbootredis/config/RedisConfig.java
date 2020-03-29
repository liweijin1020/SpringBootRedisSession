package com.springbootredis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * cache 的配置类
 * 注解：@EnableCaching来开启缓存。
 * @author lwj
 */
@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object  obj: params ) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

}
