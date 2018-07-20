package com.wangcan.study.service.impl;

import com.wangcan.study.service.PingService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangcan
 */
@RestController
public class PingServiceImpl implements PingService {
    @Override
    public String hi() {
        return "你好，服务正常";
    }
}
