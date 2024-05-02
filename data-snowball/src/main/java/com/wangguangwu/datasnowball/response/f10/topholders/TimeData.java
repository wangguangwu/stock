package com.wangguangwu.datasnowball.response.f10.topholders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeData {

    private String name;

    @JsonProperty("value")
    private Long value;

}
