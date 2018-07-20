package com.wangcan.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangcan
 * @date 2018/6/8 下午1:58
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceApplication {
    public static void main(String[] args) {
        System.out.println("==============服务启动============================");
        SpringApplication.run(ServiceApplication.class, args);
        System.out.println("==============服务启动结束============================");

    }
}
