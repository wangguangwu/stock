package com.wangguangwu.datatushare.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Response result enum.
 *
 * @author wangguangwu
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseEnum {

    /**
     * SUCCESS
     */
    SUCCESS(0, "成功"),

    /**
     * FAIL
     */
    FAIL(-1, "失败"),

    /**
     * System unknown exception.
     */
    SYSTEM_UNKNOWN(1000, "系统异常"),

    /**
     * Service exception.
     */
    SERVICE(1001, "业务异常"),

    /**
     * Unsupported
     */
    UNSUPPORTED(1002, "不支持的异常");

    private final int code;

    private final String message;

}