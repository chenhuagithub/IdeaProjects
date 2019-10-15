package com.atguigu.springbootaopproject.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chenhua
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_log")
public class AopLog {

    private int id;
    private int user_id;
    private String username;
    private String operation;
    private int time;
    private String method;
    private String params;
    private String ip;
    private Date gmt_create;


}
