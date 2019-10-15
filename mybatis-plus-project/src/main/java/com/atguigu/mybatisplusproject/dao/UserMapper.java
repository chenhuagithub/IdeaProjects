package com.atguigu.mybatisplusproject.dao;

import com.atguigu.mybatisplusproject.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectPageVo(Page page, @Param("state") Integer state);

}
