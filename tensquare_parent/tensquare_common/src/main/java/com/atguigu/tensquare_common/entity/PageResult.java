package com.atguigu.tensquare_common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
// 无参构造方法
@NoArgsConstructor
// 全参构造方法
@AllArgsConstructor
public class PageResult<T> extends Result<T> {

    private Long total;
    private List<T> rows;




}
