package com.atguigu.tensquare_recruit.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.NestingKind;
import java.io.Serializable;

@TableName("tb_enterprise")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enterprise implements Serializable {

    // id
    private String id;
    // 企业名称
    private String name;
    // 企业简介
    private String summary;
    // 企业地址
    private String address;
    // 标签列表
    private String labels;
    // 企业位置坐标
    private String coordinate;
    // 是否热门
    private String ishot;
    // LOGO
    private String logo;
    // 职位数
    private String jobcount;
    // URL
    private String url;

}
