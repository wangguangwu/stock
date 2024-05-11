package com.wangguangwu.datasnowball.response.f10.mainindicator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wangguangwu
 */
@Data
public class MainIndicatorItem {

    @JsonProperty("asset_liab_ratio")
    private BigDecimal assetLiabRatio;

    @JsonProperty("pledge_ratio")
    private BigDecimal pledgeRatio;

    @JsonProperty("net_profit_atsopc_yoy")
    private BigDecimal netProfitAtsopcYoy;

    @JsonProperty("operating_income_yoy")
    private BigDecimal operatingIncomeYoy;

    @JsonProperty("goodwill_in_net_assets")
    private BigDecimal goodwillInNetAssets;

    @JsonProperty("basic_eps")
    private BigDecimal basicEps;

    @JsonProperty("net_selling_rate")
    private BigDecimal netSellingRate;

    @JsonProperty("avg_roe")
    private BigDecimal avgRoe;

    @JsonProperty("gross_selling_rate")
    private BigDecimal grossSellingRate;

    @JsonProperty("float_shares")
    private Long floatShares;

    @JsonProperty("pb")
    private BigDecimal pb;

    @JsonProperty("np_per_share")
    private BigDecimal npPerShare;

    @JsonProperty("float_market_capital")
    private BigDecimal floatMarketCapital;

    @JsonProperty("total_revenue")
    private BigDecimal totalRevenue;

    @JsonProperty("market_capital")
    private BigDecimal marketCapital;

    @JsonProperty("pe_ttm")
    private BigDecimal peTtm;

    @JsonProperty("dividend")
    private BigDecimal dividend;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("dividend_yield")
    private BigDecimal dividendYield;

    @JsonProperty("net_profit_atsopc")
    private BigDecimal netProfitAtsopc;

    @JsonProperty("total_shares")
    private Long totalShares;

    @JsonProperty("report_date")
    private String reportDate;

}


