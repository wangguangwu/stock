package com.wangguangwu.datasnowball.service.f10;

import com.wangguangwu.datasnowball.entity.TopHoldersItemDO;
import com.wangguangwu.datasnowball.entity.TopHoldersQuitDO;
import com.wangguangwu.datasnowball.entity.TopHoldersSummaryDO;

import java.util.List;

/**
 * @author wangguangwu
 */
public interface TopHolderService {

    /**
     * 判断报告是否存在
     *
     * @param symbol     股票代码
     * @param reportName 报告名称
     * @return 是否存在
     */
    boolean existReport(String symbol, String reportName);

    /**
     * 保存十大股东数据
     *
     * @param topHoldersSummaryDO  十大股东汇总
     * @param topHoldersItemDOList 十大股东详情
     * @param topHoldersQuitDOList 十大股东退出
     */
    void saveTopHolderMessages(TopHoldersSummaryDO topHoldersSummaryDO, List<TopHoldersItemDO> topHoldersItemDOList, List<TopHoldersQuitDO> topHoldersQuitDOList);
}
