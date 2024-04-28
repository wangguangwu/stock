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

    public static final List<String> DAILY_INDICATORS_FIELDS = Arrays.asList(
            "ts_code",
            "trade_date",
            "close",
            "turnover_rate",
            "turnover_rate_f",
            "volume_ratio",
            "pe",
            "pe_ttm",
            "pb",
            "ps",
            "ps_ttm",
            "dv_ratio",
            "dv_ttm",
            "total_share",
            "float_share",
            "free_share",
            "total_mv",
            "circ_mv"
    );

    private QueryFieldsConstant() {
    }
}
