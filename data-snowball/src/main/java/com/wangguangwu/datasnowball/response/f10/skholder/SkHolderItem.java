package com.wangguangwu.datasnowball.response.f10.skholder;

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
public class SkHolderItem {

    @JsonProperty("personal_name")
    private String personalName;

    @JsonProperty("position_name")
    private String positionName;

    @JsonProperty("employ_date")
    private long employDate;

    @JsonProperty("employ_ed")
    private long employEndDate;

    @JsonProperty("resume_cn")
    private String resumeCn;

    @JsonProperty("held_num")
    private Integer heldNum;

    @JsonProperty("annual_salary")
    private Integer annualSalary;

}
