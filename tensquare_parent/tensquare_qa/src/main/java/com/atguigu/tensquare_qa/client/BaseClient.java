package com.atguigu.tensquare_qa.client;


import com.atguigu.tensquare_common.entity.Result;
import com.atguigu.tensquare_qa.client.Impl.BaseClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TENSQUARE-BASE", fallback = BaseClientImpl.class)
public interface BaseClient {

    @GetMapping("/label/{labelId}")
    public Result findById(@PathVariable("labelId") String labelId);


}
