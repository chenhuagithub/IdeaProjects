package com.atguigu.tensquare_user.bean;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
public class User {

    /**
     * create table tb_user(
     *     id varchar(20) primary key comment 'id',
     *     mobile varchar(20) comment '手机号码',
     *     password varchar(50) comment '密码',
     *     nickname varchar(20) comment '昵称',
     *     sex varchar(3) comment '性别',
     *     birthday DATETIME comment '生日',
     *     avatar varchar(100) comment '头像',
     *     email varchar(20) comment '邮箱',
     *     regdate datetime comment '注册日期',
     *     updatedate datetime comment '修改日期',
     *     lastdate datetime comment '最后登录日期',
     *     online int comment '在线时长',
     *     interest varchar(100) comment '兴趣',
     *     personality varchar(100) comment '个性',
     *     fanscount int(20) comment '粉丝数',
     *     followcount int(20) comment '关注数'
     * )default character set utf8;
     */
    private String id;
    private String mobile;
    private String password;
    private String nickname;
    private String sex;
    private Date birthday;
    private String avatar;
    private String email;
    private Date regdate;
    private Date updatedate;
    private Date lastdate;
    private Integer online;
    private String interest;
    private String personality;
    private Integer fanscount;
    private Integer followcount;


}
