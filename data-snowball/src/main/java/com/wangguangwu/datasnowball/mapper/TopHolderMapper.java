package com.wangguangwu.datasnowball.mapper;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 十大股东对应 mapper
 *
 * @author wangguangwu
 */
public interface TopHolderMapper {

    /**
     * 查询持股者持有的股票名称
     *
     * @param holderName 持股者
     * @param market     对应板块
     * @return 持股者持有的股票名称
     */
    List<String> listTopHolderInfo(@RequestParam("holderName") String holderName,
                                   @RequestParam("market") String market);


}
