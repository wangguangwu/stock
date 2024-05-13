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
        return LocalDate.now().format(YYYYMMDD_FORMATTER);
    }
}
