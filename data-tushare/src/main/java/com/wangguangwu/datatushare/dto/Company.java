package com.wangguangwu.datatushare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangguangwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private String tsCode;
    private String name;
    private String area;
    private String industry;
    private String listDate;
}
