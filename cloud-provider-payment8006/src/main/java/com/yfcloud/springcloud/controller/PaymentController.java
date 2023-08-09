package com.yfcloud.springcloud.controller;

import com.yfcloud.springcloud.entitles.CommonResult;
import com.yfcloud.springcloud.entitles.Payment;
import com.yfcloud.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
@ResponseBody
public class PaymentController {
    @Resource
    private PaymentService paymentServiceImpl;
    @Value("${server.port}")
    private String port;

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
        if(payment!=null){
            return new CommonResult<Payment>(200,"查看成功机器：  "+port,payment);
        }else {
            return new CommonResult<Payment>(500,"查看失败",null);
        }
    };

    @GetMapping("/getUUID")
    public String getPaymentt(){
        return port+ UUID.randomUUID();
    };
}
