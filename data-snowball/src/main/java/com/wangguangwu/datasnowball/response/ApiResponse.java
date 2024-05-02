package com.wangguangwu.datasnowball.response;

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
public class ApiResponse<T> {

    private T data;

    @JsonProperty("error_code")
    private Integer errorCode;

    @JsonProperty("error_description")
    private String errorDescription;

}
