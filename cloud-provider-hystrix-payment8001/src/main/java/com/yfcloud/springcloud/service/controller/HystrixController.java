package com.yfcloud.springcloud.service.controller;

import com.yfcloud.springcloud.entitles.CommonResult;
import com.yfcloud.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/Hystrix/getOK/{id}")
    public CommonResult getOK(@PathVariable Long id){
        return hystrixService.getHystrixOK();
    }

    @GetMapping("/Hystrix/getError/{id}")
    public CommonResult getError(@PathVariable Long id){
        return hystrixService.getHystrixError();
    }
}
