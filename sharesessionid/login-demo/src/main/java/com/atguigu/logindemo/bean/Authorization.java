package com.atguigu.logindemo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("authorization")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authorization implements Serializable {
    private String id;
    private String userid;
    private String permissionsid;
    private User user;
    private Permissions permissions;

    public Authorization(String id, String userid, String permissionsid){
        this.id = id;
        this.userid = userid;
        this.permissionsid =permissionsid;
    }
}
