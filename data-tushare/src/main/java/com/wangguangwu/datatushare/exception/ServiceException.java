package com.wangguangwu.datatushare.exception;

/**
 * 自定义业务异常
 *
 * @author wangguangwu
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

