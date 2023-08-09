package com.yfcloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class YFCloudZKMain80 {
    public static void main(String[] args) {
        SpringApplication.run(YFCloudZKMain80.class,args);
    }
}
