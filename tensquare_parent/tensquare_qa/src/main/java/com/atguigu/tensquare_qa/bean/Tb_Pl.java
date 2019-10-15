package com.atguigu.tensquare_qa.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("tb_pl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tb_Pl {

    private String id;
    private String problemid;
    private String labelid;

}
