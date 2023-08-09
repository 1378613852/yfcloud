package com.yfcloud.springcloud;

import com.yfcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-payment-service", configuration = MySelfRule.class) // 启动该服务时去加载自定义的ribbon配置
public class YFCloudMain80 {
    public static void main(String[] args) {
        SpringApplication.run(YFCloudMain80.class,args);
    }
}
