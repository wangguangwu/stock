package com.wangguangwu.datasnowball.response.f10.mainindicator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wangguangwu
 */
@Data
public class MainIndicatorResponseData {

    @JsonProperty("items")
    private List<MainIndicatorItem> items;

}
