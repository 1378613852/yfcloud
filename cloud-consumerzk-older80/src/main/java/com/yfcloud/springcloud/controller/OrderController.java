package com.yfcloud.springcloud.controller;


import com.yfcloud.springcloud.entitles.CommonResult;
import com.yfcloud.springcloud.entitles.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Controller
@ResponseBody
@Slf4j
public class OrderController {

    public static final String URL ="http://cloud-paymentzk-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order/insert")
    public CommonResult<Payment> getPayment(Payment payment){

        return  restTemplate.postForObject(URL+"/insertPay/",payment,CommonResult.class);
    }

    @GetMapping("/order/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){

        return  restTemplate.getForObject(URL+"/getPay/"+id,CommonResult.class);
    }

}
