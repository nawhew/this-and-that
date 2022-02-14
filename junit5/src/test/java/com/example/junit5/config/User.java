package com.example.junit5.config;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("user")
@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class User {

    @Id
    private UUID id;

    private String name;
}
