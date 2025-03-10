package com.cat_back;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RedisConnectionTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testRedisConnection() {
        String key = "test";
        String expectedValue = "value";

        assertDoesNotThrow(() -> {
            stringRedisTemplate.opsForValue().set(key, expectedValue);
            String actualValue = stringRedisTemplate.opsForValue().get(key);
            assertEquals(expectedValue, actualValue, "Redis 读取值与预期不符");
            System.out.println("Redis 测试值: " + actualValue);
        });

        // 清理测试数据
        stringRedisTemplate.delete(key);
    }
}
