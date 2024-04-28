package com.wangguangwu.datatushare.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author wangguangwu
 */
public final class DateFormatUtil {

    private static final DateTimeFormatter YYYYMMDD_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    private DateFormatUtil() {
    }

    public static String formatYYYYMMDD() {
        // 获取当前日期
        LocalDate now = LocalDate.now();

        // 使用预定义的格式化器将日期转换为字符串
//        return now.format(YYYYMMDD_FORMATTER);
        return "20240426";
    }
}
