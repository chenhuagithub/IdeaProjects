package com.atguigu.tensquare_qa.dao;

import com.atguigu.tensquare_qa.bean.Problem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProblemMapper extends BaseMapper<Problem> {



    // 最新回答

    /**
     *
     * @param labelName 标签名
     * @param index 排列序号
     * @param number 个数
     * @return
     */
    public List<Problem> newList(@Param("labelName") String labelName, @Param("index") Integer index, @Param("number") Integer number);

    // 热门回答

    /**
     *
     * @param labelName: 标签名
     * @return 最热回复列表
     */
    public List<Problem> hostList(@Param("labelName") String labelName, @Param("index") Integer index, @Param("size") Integer size);

    // 等待回答

    /**
     *
     * @param labelName: 标签名字
     * @return 等待回复列表
     */
    public List<Problem> waitList(String labelName);


}
