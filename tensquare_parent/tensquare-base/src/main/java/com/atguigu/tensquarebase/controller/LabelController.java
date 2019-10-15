package com.atguigu.tensquarebase.controller;


import com.atguigu.tensquare_common.entity.Result;
import com.atguigu.tensquare_common.entity.StatusCode;
import com.atguigu.tensquarebase.bean.Label;
import com.atguigu.tensquarebase.service.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("标签相关请求")
@RestController
@CrossOrigin
@RequestMapping("/label")
@RefreshScope
public class LabelController {

    @Autowired
    private LabelService labelService;

    // 推荐标签列表
    @ApiOperation("获取全部标签列表")
    @GetMapping
    public Result findAll(){
        System.out.println();
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }


    @Value("${server.port}")
    private String myport;

    @Value(("${ip}"))
    private String ip;

    @ApiOperation("根据id查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "labelId", value = "标签id, 卸载路径上"),
    })
    @GetMapping("/{labelId}")
    public Result findById(@PathVariable("labelId") String labelId){
        System.out.println("ip为:"+ip);
        System.out.println("我的端口号是:"+myport);
        return new Result(true, StatusCode.OK, "根据id查询成功", labelService.findById(labelId));
    }


    @ApiOperation("保存标签数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "标签id"),
            @ApiImplicitParam(name = "labelname", value = "标签名"),
            @ApiImplicitParam(name = "state", value = "标签状"),
            @ApiImplicitParam(name = "count", value = "标签使用数量"),
            @ApiImplicitParam(name = "recommend", value = "是否推荐"),
            @ApiImplicitParam(name = "fans", value = "粉丝数量"),
    })
    @PostMapping
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK, "数据添加成功");
    }

    @ApiOperation("根据id更新数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "labelId", value = "路径id"),
            @ApiImplicitParam(name = "id", value = "标签id"),
            @ApiImplicitParam(name = "labelname", value = "标签名"),
            @ApiImplicitParam(name = "state", value = "标签状"),
            @ApiImplicitParam(name = "count", value = "标签使用数量"),
            @ApiImplicitParam(name = "recommend", value = "是否推荐"),
            @ApiImplicitParam(name = "fans", value = "粉丝数量"),
    })
    @PutMapping("/{labelId}")
    public Result update(@PathVariable String labelId, @RequestBody Label label){
        labelService.update(labelId, label);
        return new Result(true, StatusCode.OK, "更新成功");
    }


    @ApiOperation("根据id删除数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "labelId", value = "标签id"),
    })
    @DeleteMapping("/{labelId}")
    public Result deleteById(@PathVariable String labelId){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "根据id删除数据成功");
    }

    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "标签id"),
            @ApiImplicitParam(name = "labelname", value = "标签名"),
            @ApiImplicitParam(name = "state", value = "标签状"),
            @ApiImplicitParam(name = "count", value = "标签使用数量"),
            @ApiImplicitParam(name = "recommend", value = "是否推荐"),
            @ApiImplicitParam(name = "fans", value = "粉丝数量"),
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页数据的条数"),


    })
    @PostMapping("/search/{size}/{current}")
    public Result findSearch(@RequestBody Label label, @PathVariable Integer current, @PathVariable Integer size){
        List<Label> list = labelService.findSearch(label, current, size);
        return new Result(true, StatusCode.OK, "根据id删除数据成功", list);
    }


}
