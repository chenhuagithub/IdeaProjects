package com.atguigu.tensquare_qa.bean;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("tb_reply")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

/**
 * create table tb_reply(
 *     id int primary key comment 'id',
 *     problemid int comment '问题id',
 *     userid int comment '回答人id',
 *     content text comment '回答内容',
 *     createtime datetime comment '回答日期',
 *     updatetime datetime comment '更新日期',
 *     nickname varchar(20) comment '回答人昵称'
 * )default character set utf8;
 */
    private String id;
    private String problemid;
    private String userid;
    private String content;
    private Date createtime;
    private Date updatetime;
    private String nickname;

}
