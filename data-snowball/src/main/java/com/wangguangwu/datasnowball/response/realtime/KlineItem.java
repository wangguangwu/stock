package com.wangguangwu.datasnowball.response.realtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * K 线图对应实体类
 *
 * @author wangguangwu
 */
@Data
public class KlineItem {
    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("volume")
    private String volume;

    @JsonProperty("open")
    private String open;

    @JsonProperty("high")
    private String high;

    @JsonProperty("low")
    private String low;

    @JsonProperty("close")
    private String close;

    @JsonProperty("chg")
    private String chg;

    @JsonProperty("percent")
    private String percent;

    @JsonProperty("turnoverrate")
    private String turnoverrate;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("volume_post")
    private String volumePost;

    @JsonProperty("amount_post")
    private String amountPost;

    @JsonProperty("pe")
    private String pe;

    @JsonProperty("pb")
    private String pb;

    @JsonProperty("ps")
    private String ps;

    @JsonProperty("pcf")
    private String pcf;

    @JsonProperty("market_capital")
    private String marketCapital;

    @JsonProperty("balance")
    private String balance;

    @JsonProperty("hold_volume_cn")
    private String holdVolumeCn;

    @JsonProperty("hold_ratio_cn")
    private String holdRatioCn;

    @JsonProperty("net_volume_cn")
    private String netVolumeCn;

    @JsonProperty("hold_volume_hk")
    private String holdVolumeHk;

    @JsonProperty("hold_ratio_hk")
    private String holdRatioHk;

    @JsonProperty("net_volume_hk")
    private String netVolumeHk;
}

