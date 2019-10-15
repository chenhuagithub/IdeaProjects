package com.atguigu.tensquare_recruit.service;

import com.atguigu.tensquare_recruit.bean.Enterprise;
import com.atguigu.tensquare_recruit.dao.EnterpriseMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    // 查询所有热门企业
    public List<Enterprise> hotList(String ishot){
        return enterpriseMapper.selectList(new QueryWrapper<Enterprise>().eq("ishot", ishot));
    }




}
