package com.wangguangwu.datatushare.constant;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangguangwu
 */
public final class QueryFieldsConstant {

    public static final List<String> STOCK_BASIC_FIELDS = Arrays.asList("ts_code", "name", "area", "market", "industry", "list_date");

    public static final List<String> MARKET_DATA_FIELDS = Arrays.asList("ts_code", "trade_date",
            "open",
            "high",
            "low",
            "close",
            "pre_close",
            "change",
            "pct_chg",
            "vol",
            "amount");

    private QueryFieldsConstant() {
    }
}
