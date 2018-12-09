package com.example.springboot;

import com.SpringbootApplication;
import com.dao_jpa.UserRepository;
import com.dao_jpa.UserRepositoryByName;
import com.pojo.User;
import com.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootApplicationTests {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepositoryByName userRepositoryByName;

    @Test
    public void contextLoads() {
        System.out.println(userService.selectById(1).toString());
        System.out.println(userService.selectById(1).toString());
    }

    @Test
    public void jpa_test() {
        User user = new User();
        user.setName("Jane");
        user.setPassword("dfsdfs33");
        userRepository.save(user);
    }

    @Test
    public void jpaTest() {
        System.out.println(this.userRepositoryByName.findByName("电饭锅"));
    }
}
