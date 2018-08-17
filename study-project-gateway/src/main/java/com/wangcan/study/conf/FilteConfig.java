package com.wangcan.study.conf;

import com.wangcan.study.filter.QueryParamPreFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangcan
 */
//@Configuration
public class FilteConfig {
//    @Bean
    public QueryParamPreFilter queryParamPreFilter(){
        return new QueryParamPreFilter();
    }
}
