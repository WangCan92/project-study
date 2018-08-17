package com.wangcan.study.pojo.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author wangcan
 */
@Setter
@Getter
@Builder
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = 7057500347685957846L;

    private String userId;
    private String sourceId;

}
