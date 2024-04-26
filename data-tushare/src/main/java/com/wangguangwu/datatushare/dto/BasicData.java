package com.wangguangwu.datatushare.dto;

import lombok.Data;

import java.util.List;

/**
 * @author wangguangwu
 */
@Data
public class BasicData {
    private List<String> fields;
    private List<List<String>> items;
}



