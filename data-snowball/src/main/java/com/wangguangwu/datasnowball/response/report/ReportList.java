package com.wangguangwu.datasnowball.response.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wangguangwu
 */
@Data
public class ReportList {

    @JsonProperty("list")
    private List<Report> reports;

}
