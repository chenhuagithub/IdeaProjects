package com.atguigu.tensquare_user;

import com.atguigu.tensquare_common.util.IdWorker;
import com.atguigu.tensquare_user.bean.User;
import com.atguigu.tensquare_user.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TensquareUserApplicationTests {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        for (int i = 0; i < 30; i++) {
            User user = new User(idWorker.nextId() + "",
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    (int) (Math.random() * 2) + "",
                    new Date(),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    new Date(),
                    new Date(),
                    new Date(),
                    (int)(Math.random()*50),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    (int)(Math.random()*100),
                    (int)(Math.random()*40)
            );

            userMapper.insert(user);
        }


    }

}
