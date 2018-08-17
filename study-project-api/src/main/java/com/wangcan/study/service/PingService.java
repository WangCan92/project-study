package com.wangcan.study.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static com.wangcan.study.FeignConstant.FEIGN_NAME;

/**
 * @author wangcan
 */
@FeignClient(FEIGN_NAME)
public interface PingService {

    @RequestMapping(value = "/hi",method = RequestMethod.POST)
    String hi(HttpServletRequest reques);

    @RequestMapping(value = "/tryLock",method = RequestMethod.POST)
    void tryLock(String key,String value);
}
