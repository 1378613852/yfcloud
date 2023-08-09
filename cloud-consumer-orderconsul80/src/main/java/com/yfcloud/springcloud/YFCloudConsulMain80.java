package com.yfcloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class YFCloudConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(YFCloudConsulMain80.class,args);
    }
}
