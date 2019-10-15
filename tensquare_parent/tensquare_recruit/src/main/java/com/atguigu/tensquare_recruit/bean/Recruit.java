package com.atguigu.tensquare_recruit.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@TableName("tb_recruit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruit implements Serializable {

    private String id;
    // 职位名称
    private String jobname;
    // 薪酬范围
    private String salary;
    // 经验要求
    private String conditions;
    // 学历要求
    private String education;
    // 任职方式
    private String type;
    // 办公地址
    private String address;
    // 企业id
    private String eid;
    // 创建日期
    private Date createtime;
    // 状态
    private String state;
    // 网址
    private String url;
    // 标签
    private String label;
    // 职位描述
    private String content1;
    // 职位要求
    private String content2;



}
