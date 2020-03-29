package com.springbootredis;

import com.springbootredis.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void saveTest() {
        stringRedisTemplate.opsForValue().set("a","aa");
        Assert.assertEquals("aa",stringRedisTemplate.opsForValue().get("a"));
    }

    @Test
    public void saveObjTest() throws InterruptedException {
        User user = new User(1L, "xiaogang", "123456", "xiaogang@qq.com", "a", "1922-01-01");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("user1",user);
        operations.set("user2",user,1, TimeUnit.SECONDS);

        Thread.sleep(1000);
        redisTemplate.delete("user2");
        Boolean exists = redisTemplate.hasKey("user2");
        if(exists) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
