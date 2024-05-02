package com.wangguangwu.datasnowball.response.f10.skholder;

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
public class SkHolderResponseData {

    private List<SkHolderItem> items;

}
