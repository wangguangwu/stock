package com.wangguangwu.datasnowball.response.f10.topholders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopHoldersResponseData {

    private List<TimeData> times;
    private TotalData total;
    private List<HolderData> quit;
    private List<ItemData> items;

}
