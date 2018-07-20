package com.wangcan.study.controller;

import com.wangcan.study.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangcan
 */
@RestController
public class PingController {
    @Autowired
    private PingService pingService;

    @RequestMapping("/ping")
    public String ping(){
        return pingService.hi();
    }


}
