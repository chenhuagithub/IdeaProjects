package com.atguigu.tensquarebase;

import com.atguigu.tensquare_common.util.IdWorker;
import com.atguigu.tensquarebase.bean.Label;
import com.atguigu.tensquarebase.dao.LabelMapper;
import com.atguigu.tensquarebase.service.LabelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TensquareBaseApplicationTests {

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private IdWorker idWorker;

    @Test
    public void test2(){
        List<Label> aaa = labelMapper.selectList(new QueryWrapper<Label>().select("id"));
        for (int i = 0; i < 33; i++) {
            System.out.print("\""+aaa.get(i).getId()+"\",");
        }
    }

    @Test
    public void contextLoads() {

        for (int i = 0; i < 30; i++) {
            Label label = new Label(idWorker.nextId() + "",
                    UUID.randomUUID().toString().substring(0, 8),
                    (int) (Math.random() * 3) + "",
                    (int) (Math.random() * 2),
                    (int) (Math.random() * 2) + "",
                    (int) (Math.random() * 100)
            );
            labelMapper.insert(label);
        }




    }
}



