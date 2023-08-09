package com.yfcloud.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.yfcloud.springcloud.entitles.CommonResult;
import com.yfcloud.springcloud.entitles.Payment;
import com.yfcloud.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentServiceImpl;
    @Value("${server.port}")
    private String port;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/insertPay")
    public CommonResult<Payment> insertPayment(@RequestBody Payment payment){
        int i = paymentServiceImpl.insertPayment(payment);
        if(i>0){
            return new CommonResult<Payment>(200,"添加成功 机器：  "+port,payment);
        }else{
            return new CommonResult<Payment>(500,"添加失败",null);
        }
    };

    @GetMapping("/getPay/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = paymentServiceImpl.getPayment(id);
        System.out.println("测试at啊");
        if(payment!=null){
            return new CommonResult<Payment>(200,"查看成功机器：  "+port,payment);
        }else {
            return new CommonResult<Payment>(500,"查看失败",null);
        }
    };

    @GetMapping("/getDiscoveryClient")
    public  DiscoveryClient getDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String s:services) {
            log.info("Services :"+s);
            List<ServiceInstance> instances = discoveryClient.getInstances(s);
            for (ServiceInstance in:instances
            ) {
                log.info("ServiceId :"+in.getServiceId()+"Host :"+in.getHost()+"Port :"+in.getPort()+"Uri :"+in.getUri());
            }
        }
        return discoveryClient;
    }
}
