package com.atguigu.tensquare_aticle.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@TableName("tb_article")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

    /**
     * create table tb_article(
     *          id varchar(20) primary key comment 'id',
     *          columnid varchar(20) comment '专栏id',
     *          userid varchar(20) comment '用户id',
     *          title varchar(100) comment '文章标题',
     *          content text comment '文章内容',
     *          image varchar(100) comment '文章封面',
     *          createtime DATETIME comment '发表日期',
     *          updatetime DATETIME comment '修改日期',
     *          ispublic varchar(5) comment '是否公开',
     *          istop varchar(5) comment '是否置顶',
     *          visits int comment '流浪量',
     *          thumbup int comment '点赞数',
     *          comment int comment '评论数',
     *          state varchar(2) comment '审核状态 0: 未审核  1: 审核',
     *          channelid int comment '所属频道',
     *          url varchar(100) comment 'URL文本',
     *          type varchar(2) comment '文章类型 0: 分享, 1: 专栏'
     *      )default character set utf8
     */

    private String id;
    private String columnid;
    private String userid;
    private String title;
    private String content;
    private String image;
    private Date createtime;
    private Date updatetime;
    private String ispublic;
    private String istop;
    private Integer visits;
    private Integer thumbup;
    private Integer comment;
    private String state;
    private Integer channelid;
    private String url;
    private String type;

}
