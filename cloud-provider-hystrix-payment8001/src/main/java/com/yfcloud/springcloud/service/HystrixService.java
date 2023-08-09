package com.yfcloud.springcloud.service;

import com.yfcloud.springcloud.entitles.CommonResult;

public interface HystrixService {

    public CommonResult getHystrixOK();

    public CommonResult getHystrixError();
}
