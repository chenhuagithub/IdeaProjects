package com.atguigu.tensquare_recruit.service;

import com.atguigu.tensquare_recruit.bean.Recruit;
import com.atguigu.tensquare_recruit.dao.RecruitMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {

    @Autowired
    RecruitMapper recruitMapper;


    /**
     *
     * @param state 状态 0: 关闭, 1: 开启, 2:推荐
     * @return 推荐列表
     */
    public List<Recruit> recommend_or_newList(String state){
        List<Recruit> recruitsList = recruitMapper.selectList(new QueryWrapper<Recruit>().eq("state", state).orderByDesc("createtime"));
        return recruitsList;
    }




}
