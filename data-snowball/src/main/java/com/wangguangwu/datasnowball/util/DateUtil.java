package com.wangguangwu.datasnowball.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author wangguangwu
 */
public final class DateUtil {

    private DateUtil() {
    }

    public static LocalDate convertLongToLocalDate(long timestamp) {
        return Instant.ofEpochMilli(timestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
