package com.example.junit5.config;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@TestConfiguration
@Slf4j
public class TestRedisConfiguration {

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    public TestRedisConfiguration() {
        redisServer = new RedisServer(RedisInfo.PORT);
        log.info("레디스 서버 상태 after cont.: " + redisServer.isActive());
        log.info("레디스 서버 상태 after cont.: " + redisServer.ports());
    }

    @PostConstruct
    public void startRedis() throws IOException {
        redisServer.start();
        log.info("레디스 서버 상태 : " + redisServer.isActive());
        log.info("레디스 서버 상태 : " + redisServer.ports());
    }

    @PreDestroy
    public void stopRedis() {
        redisServer.stop();
    }
}