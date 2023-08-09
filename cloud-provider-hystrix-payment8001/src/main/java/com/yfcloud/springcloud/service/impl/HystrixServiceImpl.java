package com.yfcloud.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yfcloud.springcloud.entitles.CommonResult;
import com.yfcloud.springcloud.service.HystrixService;
import org.springframework.stereotype.Service;

@Service
public class HystrixServiceImpl implements HystrixService {
    @Override
    public CommonResult getHystrixOK() {

        return new CommonResult(200,"ok");
    }

    @HystrixCommand(fallbackMethod = "defaultError", commandProperties = {@HystrixProperty(
            name="execution.isolation.thread.timeoutInMilliseconds",value="3000"
    )})
    @Override
    public CommonResult getHystrixError() {
        //睡眠3s
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"ok");
    }
    public CommonResult defaultError(){
        return new CommonResult(500,"error");
    }
}
