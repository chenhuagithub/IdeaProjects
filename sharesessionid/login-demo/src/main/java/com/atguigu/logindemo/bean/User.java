package com.atguigu.logindemo.bean;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String id;
    private String username;
    private String password;
}
