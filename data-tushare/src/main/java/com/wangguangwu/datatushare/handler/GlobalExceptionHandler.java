package com.wangguangwu.datatushare.handler;

import com.wangguangwu.datatushare.enums.ResponseEnum;
import com.wangguangwu.datatushare.exception.ServiceException;
import com.wangguangwu.datatushare.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Define global exception handling
 *
 * @author wangguangwu
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle exception.
     */
    @ExceptionHandler(Exception.class)
    private Response<String> handleException(Exception exception) {
        return Response.error(ResponseEnum.SYSTEM_UNKNOWN, exception.getMessage());
    }

    /**
     * Handle serviceException.
     */
    @ExceptionHandler(ServiceException.class)
    private Response<String> handleServiceException(ServiceException exception) {
        return Response.error(ResponseEnum.SERVICE.getCode(), exception.getMessage());
    }

    /**
     * Handle unSupported Exception.
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response<String> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
        return Response.error(ResponseEnum.UNSUPPORTED, exception.getMessage());
    }
}
