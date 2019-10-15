package com.atguigu.tensquare_qa;

import com.atguigu.tensquare_common.util.IdWorker;
import com.atguigu.tensquare_qa.bean.Problem;
import com.atguigu.tensquare_qa.bean.Tb_Pl;
import com.atguigu.tensquare_qa.dao.ProblemMapper;
import com.atguigu.tensquare_qa.dao.Tb_PlMapper;
import com.atguigu.tensquare_qa.service.ProblemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TensquareQaApplicationTests {

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    IdWorker idWorker;

    @Autowired
    Tb_PlMapper tb_plMapper;

    @Autowired
    ProblemService problemService;


    @Test
    public void test6(){
        PageHelper.startPage(2,2);
        List<Problem> problems = problemMapper.newList("1173426360086040576", 1, 2);
        PageInfo<Problem> info = new PageInfo<>(problems);
        List<Problem> list = info.getList();
        System.out.println("==============");
        System.out.println(list);
        System.out.println("==============");

    }


    @Test
    public void test5(){
        List<Problem> problems = problemService.newList("1173426360086040576", 1, 2);
        System.out.println(problems);
        System.out.println("==============");
        System.out.println(problems.size());
        System.out.println("===============");
    }


    @Test
    public void test2(){
        List<Problem> dkfj = problemMapper.newList("1173426360086040576", 2, 4);
        System.out.println(dkfj);
    }


    @Test
    public void contextLoads() {
        for (int i = 0; i < 30; i++) {
            Problem problem = new Problem(idWorker.nextId() + "",
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    new Date(),
                    new Date(),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    (int) (Math.random() * 100),
                    (int) (Math.random() * 100),
                    (int) (Math.random() * 100),
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    new Date()
            );
            problemMapper.insert(problem);
        }
    }



    @Test
    public void test4(){
        List<Problem> problems = problemMapper.newList("1173426360086040576", 1, 2);
        for (int i = 0; i < problems.size(); i++) {
            System.out.println(problems.get(i));
        }
    }

    @Test
    public void test3(){

        String[] aaa = {"1173426360086040576","1173427280299560960","1173427429931356160","1173438575094665216","1173438752933154816","1173867214546276352","1173867218564419584","1173867218690248704","1173867218736386048","1173867218769940480","1173867218803494912","1173867218841243648","1173867218874798080","1173867218912546816","1173867218946101248","1173867218979655680","1173867219017404416","1173867219050958848","1173867219088707584","1173867219126456320","1173867219147427840","1173867219180982272","1173867219218731008","1173867219252285440","1173867219290034176","1173867219323588608","1173867219361337344","1173867219399086080","1173867219436834816","1173867219470389248"};
        List labelList = new ArrayList();
        for (int i = 0; i < aaa.length; i++) {
            labelList.add(aaa[i]);
        }

        List problemList = new ArrayList();
        List<Problem> problems = problemMapper.selectList(null);
        for (int i = 0; i < problems.size(); i++) {
            problemList.add(problems.get(i).getId().toString());
        }


        for (int i = 0; i < 100; i++) {
            Tb_Pl tb_pl = new Tb_Pl(idWorker.nextId() + "",
                    (String) problemList.get((int) (Math.random() * 30)),
                    (String) labelList.get((int) (Math.random() * 30)));
            tb_plMapper.insert(tb_pl);
        }



    }

}
