package com.atguigu.tensquare_qa.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("tb_problems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Problem {
    /**
     * create table tb_problems(
     *     id varchar(20) primary key ,
     *     title varchar(100) comment '问题标题',
     *     content text comment '问题内容',
     *     createtime DATETIME comment '发布时间',
     *     updatetime datetime comment '更新时间',
     *     userid varchar(20) comment '发布人id',
     *     nickname varchar(20) comment '发布人昵称',
     *     visits int comment '浏览量',
     *     thumbup int comment '点赞数',
     *     reply int comment '回复数',
     *     solve varchar(10) comment '是否解决',
     *     replyname varchar(20) comment '最新回复人',
     *     replytime varchar(20) comment '最新回复时间'
     * )default character set utf8;
     */
    // id
    private String id;
    // 问题标题
    private String title;
    // 问题内容
    private String content;
    // 发布时间
    private Date createtime;
    // 更新时间
    private Date updatetime;
    // 发布人id
    private String userid;
    // 发布人昵称
    private String nickname;
    // 浏览量
    private Integer visits;
    // 点赞数
    private Integer thumbup;
    // 回复数
    private Integer reply;
    // 是否解决
    private String solve;
    // 最新回复人
    private String replyname;
    // 最新回复时间
    private Date replytime;

}
