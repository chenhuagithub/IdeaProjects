package com.atguigu.tensquare_qa.service;


import com.atguigu.tensquare_qa.bean.Problem;
import com.atguigu.tensquare_qa.dao.ProblemMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {

    @Autowired
    private ProblemMapper problemMapper;


    /**
     *
     * @param labelName 标签名
     * @param current 但前页码
     * @param size 没页的大小
     * @return
     */
    public List<Problem> newList(String labelName, Integer current, Integer size){
        List<Problem> problemsList = problemMapper.newList(labelName, (current - 1)*size, size);
        return problemsList;
    }

    public List<Problem> hotList(String labelName, Integer current, Integer size){
        List<Problem> problemsList = problemMapper.newList(labelName, (current - 1)*size, size);
        return problemsList;
    }

    public List<Problem> waitList(String labelName, Integer current, Integer size){
        List<Problem> problemsList = problemMapper.newList(labelName, (current - 1)*size, size);
        return problemsList;
    }


}
