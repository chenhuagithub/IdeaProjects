package com.atguigu.logindemo.dao;

import com.atguigu.logindemo.bean.Authorization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface AuthorizationMapper extends BaseMapper<Authorization> {

    public Authorization  findPerms(String username);
//

}
