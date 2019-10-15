package com.atguigu.tensquarebase.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@TableName("tb_label")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("标签实体")
public class Label implements Serializable {

    @ApiModelProperty("标签id")
    private String id;
    @ApiModelProperty("标签名字")
    private String labelname;
    @ApiModelProperty("标签状态")
    private String state;
    @ApiModelProperty("标签使用数量")
    private Integer count;
    @ApiModelProperty("是否推荐标签")
    private String recommend;
    @ApiModelProperty("粉丝数")
    private Integer fans;


}
