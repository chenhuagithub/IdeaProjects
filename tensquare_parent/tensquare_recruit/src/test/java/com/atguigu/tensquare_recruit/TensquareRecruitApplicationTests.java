package com.atguigu.tensquare_recruit;

import com.atguigu.tensquare_common.util.IdWorker;
import com.atguigu.tensquare_recruit.bean.Enterprise;
import com.atguigu.tensquare_recruit.bean.Recruit;
import com.atguigu.tensquare_recruit.dao.EnterpriseMapper;
import com.atguigu.tensquare_recruit.dao.RecruitMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TensquareRecruitApplicationTests {

    @Autowired
    IdWorker idWorker;

    @Autowired
    EnterpriseMapper enterpriseMapper;

    @Autowired
    RecruitMapper recruitMapper;


    @Test
    public void contextLoads() {

        for (int i = 0; i < 30; i++) {
            Enterprise enterprise = new Enterprise(idWorker.nextId() + "",
                    UUID.randomUUID().toString().substring(0, 10),
                    UUID.randomUUID().toString().substring(0, 10),
                    UUID.randomUUID().toString().substring(0, 10),
                    UUID.randomUUID().toString().substring(0, 10),
                    UUID.randomUUID().toString().substring(0, 10),
                    (int)(Math.random()*3)+"",
                    UUID.randomUUID().toString().substring(0, 10),
                    (int)(Math.random()*100)+"",
                    UUID.randomUUID().toString().substring(0, 10));
            enterpriseMapper.insert(enterprise);

        }

    }

    @Test
    public void test2(){
        for (int i = 0; i < 30; i++) {
            Recruit recruit = new Recruit(idWorker.nextId() + "",
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    new Date(),
                    (int) (Math.random() * 3) + "",
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8)
            );
            recruitMapper.insert(recruit);
        }

    }

}
