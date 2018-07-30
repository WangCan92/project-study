package com.wangcan.study.common.exception;

/**
 * @author wangcan
 */
public enum CommonExceptionMsg {
    SYS_ERROR(111111,"系统异常"),COMMON_EXCEP(1000001,"异常");
    private int code;
    private String msg;

    CommonExceptionMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
