package com.test.springcloud;

import com.test.SpringcloudApplication;
import com.test.rabbitmq.Sender;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringcloudApplication.class)
public class SpringcloudApplicationTests {
	@Autowired
	private Sender sender;
	@Test
	public void contextLoads() {
		sender.send("hello");
	}
}
