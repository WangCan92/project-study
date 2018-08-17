package com.wangcan.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wangcan
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        System.out.println("==============gateway开始==================");
        SpringApplication.run(ZuulApplication.class,args);
        System.out.println("==============gateway结束==================");
    }
}
