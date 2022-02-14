package com.example.junit5;

import com.example.junit5.config.RedisConfig;
import com.example.junit5.config.TestRedisConfiguration;
import com.example.junit5.config.User;
import com.example.junit5.config.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Import(TestRedisConfiguration.class)
@DataRedisTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("저장")
    void save() {
        // given
        User user = new User();

        // when
        User persistUser = this.userRepository.save(user);

        // then
        assertNotNull(persistUser);
    }
}
