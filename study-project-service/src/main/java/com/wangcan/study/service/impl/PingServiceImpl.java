package com.wangcan.study.service.impl;

import com.wangcan.study.service.PingService;
import com.wangcan.study.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangcan
 */
@RestController
public class PingServiceImpl implements PingService {
    @Value("${name}")
    private String name;
    @Override
    public String hi(HttpServletRequest request) {
        return "你好，服务正常!"+name+",header:"+request.getHeader("baseRequest")+",loginToken="+request.getHeader("loginToken");
    }

    @Override
    public void tryLock(String key, String value) {
        RedisUtil.tryLock("trylocktest","123456");
    }
}
