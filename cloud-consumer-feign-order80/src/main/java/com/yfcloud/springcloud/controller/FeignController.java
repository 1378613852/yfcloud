package com.yfcloud.springcloud.controller;


import com.yfcloud.springcloud.entitles.CommonResult;
import com.yfcloud.springcloud.entitles.Payment;
import com.yfcloud.springcloud.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FeignController {

    @Resource
    private FeignService feignService;

    @GetMapping("/order/insert")
    public CommonResult<Payment> getPayment(Payment payment){

        return  feignService.insertPayment(payment);
    }

    @GetMapping("/order/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){

        return  feignService.getPayment(id);
    }
}
