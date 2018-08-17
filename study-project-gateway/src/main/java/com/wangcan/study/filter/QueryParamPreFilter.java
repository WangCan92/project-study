package com.wangcan.study.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.wangcan.study.pojo.bo.BaseRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author wangcan
 */
@Component
public class QueryParamPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /*RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (StringUtils.isBlank(request.getHeader("loginToken")))
            return false;*/
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Map<String,String>headers = ctx.getZuulRequestHeaders();
//        String token = headers.get("loginToken");
        String token = request.getHeader("loginToken");
        //根据token查找redis中登陆信息
        BaseRequest baseRequest = BaseRequest.builder().sourceId(token).userId(token+"user").build();
        ctx.addZuulRequestHeader("baseRequest",JSON.toJSONString(baseRequest));
        return null;
    }
}
