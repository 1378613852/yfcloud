package com.yfcloud.springcloud.service;

import com.yfcloud.springcloud.entitles.CommonResult;
import com.yfcloud.springcloud.entitles.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "cloud-payment-service")
public interface FeignService {
    @PostMapping("/insertPay")
    public CommonResult<Payment> insertPayment(@RequestBody Payment payment);

    @GetMapping("/getPay/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
