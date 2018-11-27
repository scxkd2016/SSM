package com.example.springboot;

import com.SpringbootApplication;
import com.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootApplicationTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void contextLoads() {
        JedisConnectionFactory
        System.out.println(userService.selectById(1).toString());
        System.out.println(userService.selectById(1).toString());
    }

}
