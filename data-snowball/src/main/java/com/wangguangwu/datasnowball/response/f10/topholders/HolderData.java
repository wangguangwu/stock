package com.wangguangwu.datasnowball.response.f10.topholders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolderData {

    @JsonProperty("held_num")
    private Long heldNum;

    @JsonProperty("held_ratio")
    private BigDecimal heldRatio;

    @JsonProperty("holder_rank")
    private Integer holderRank;

    @JsonProperty("holder_name")
    private String holderName;

}
