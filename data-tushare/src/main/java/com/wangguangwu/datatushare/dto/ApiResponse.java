package com.wangguangwu.datatushare.dto;

import lombok.Data;

/**
 * @author wangguangwu
 */
@Data
public class ApiResponse {
    private int code;
    private String msg;
    private BasicData data;
}
