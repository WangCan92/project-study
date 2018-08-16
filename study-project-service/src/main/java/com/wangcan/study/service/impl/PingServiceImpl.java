package com.wangcan.study.service.impl;

import com.wangcan.study.service.PingService;
import com.wangcan.study.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangcan
 */
@RestController
public class PingServiceImpl implements PingService {
    @Value("${name}")
    private String name;
    @Override
    public String hi() {
        return "你好，服务正常!"+name;
    }

    @Override
    public void tryLock(String key, String value) {
        RedisUtil.tryLock("trylocktest","123456");
    }
}
