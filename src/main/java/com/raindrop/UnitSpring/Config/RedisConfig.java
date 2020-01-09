package com.raindrop.UnitSpring.Config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/*
 * @Description TODO RedsiConfig
 * @Author Raindrop
 * @Date 2019/11/14
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate redisTemplate=new RedisTemplate();
        //建立Redis的连接
        redisTemplate.setConnectionFactory(factory);
        //指定Key的序列化的形式，避免出现\xac\xed\x00\x05t\x00\tb类似的值
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //指定Value的序列化的形式，避免出现\xac\xed\x00\x05t\x00\tb类似的值
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        System.out.println("suscessful");
        return redisTemplate;
    }
}