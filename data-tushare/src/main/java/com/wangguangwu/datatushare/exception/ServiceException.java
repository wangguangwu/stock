package com.wangguangwu.datatushare.exception;

import com.wangguangwu.datatushare.enums.ResponseEnum;

/**
 * 自定义业务异常
 *
 * @author wangguangwu
 */
@SuppressWarnings("unused")
public class ServiceException extends RuntimeException {

    protected final Integer code;
    protected final String message;

    public ServiceException() {
        this.code = ResponseEnum.SERVICE.getCode();
        this.message = ResponseEnum.SERVICE.getMessage();
    }

    public ServiceException(String message) {
        this.message = message;
        this.code = ResponseEnum.SERVICE.getCode();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.code = ResponseEnum.SERVICE.getCode();
    }
}

