package com.wangguangwu.datatushare.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author wangguangwu
 */
@SuppressWarnings("all")
public final class DateFormatUtil {

    private static final DateTimeFormatter YYYYMMDD_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    private DateFormatUtil() {
    }

    public static String formatYYYYMMDD() {
        return LocalDate.now().format(YYYYMMDD_FORMATTER);
    }

    /**
     * 返回从今天起的几天前的日期，格式化为YYYY-MM-DD。
     *
     * @param daysAgo 要回溯的天数
     * @return 格式化后的日期字符串
     */
    public static String formatYYYYMMDD(int daysAgo) {
        LocalDate date = LocalDate.now().minusDays(daysAgo);
        return date.format(YYYYMMDD_FORMATTER);
    }

    /**
     * 返回当前月的第一天，格式化为YYYYMMDD。
     *
     * @return 格式化后的日期字符串
     */
    public static String getFirstDayOfCurrentMonth() {
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        return firstDayOfMonth.format(YYYYMMDD_FORMATTER);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 90; i++) {
            String date = DateFormatUtil.formatYYYYMMDD(i);
            System.out.println(date);
        }
    }
}
