package com.wangguangwu.datasnowball.service.f10.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datasnowball.entity.TopHoldersItemDO;
import com.wangguangwu.datasnowball.entity.TopHoldersQuitDO;
import com.wangguangwu.datasnowball.entity.TopHoldersSummaryDO;
import com.wangguangwu.datasnowball.service.basic.TopHoldersItemService;
import com.wangguangwu.datasnowball.service.basic.TopHoldersQuitService;
import com.wangguangwu.datasnowball.service.basic.TopHoldersSummaryService;
import com.wangguangwu.datasnowball.service.f10.TopHolderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class TopHolderServiceImpl implements TopHolderService {

    @Resource
    private TopHoldersSummaryService topHoldersSummaryService;
    @Resource
    private TopHoldersItemService topHoldersItemService;
    @Resource
    private TopHoldersQuitService topHoldersQuitService;

    @Override
    public boolean existReport(String symbol, String reportName) {
        return topHoldersSummaryService.count(getReportExists(symbol, reportName)) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveTopHolderMessages(TopHoldersSummaryDO topHoldersSummaryDO, List<TopHoldersItemDO> topHoldersItemDOList, List<TopHoldersQuitDO> topHoldersQuitDOList) {
        getSummaryId(topHoldersSummaryDO).ifPresent(
                summaryId -> {
                    if (CollUtil.isNotEmpty(topHoldersItemDOList)) {
                        topHoldersItemDOList.forEach(item -> item.setSummaryId(summaryId));
                        topHoldersItemService.saveBatch(topHoldersItemDOList);
                    }
                    if (CollUtil.isNotEmpty(topHoldersQuitDOList)) {
                        topHoldersQuitDOList.forEach(quit -> quit.setSummaryId(summaryId));
                        topHoldersQuitService.saveBatch(topHoldersQuitDOList);
                    }
                }
        );
    }

    private Optional<Integer> getSummaryId(TopHoldersSummaryDO topHoldersSummaryDO) {
        boolean save = topHoldersSummaryService.save(topHoldersSummaryDO);
        if (!save) {
            return Optional.empty();
        }
        List<TopHoldersSummaryDO> summaryDOList = topHoldersSummaryService.list(getReportExists(topHoldersSummaryDO.getSymbol(), topHoldersSummaryDO.getReportName()));

        return summaryDOList.stream()
                .findFirst()
                .map(TopHoldersSummaryDO::getId);
    }

    private static LambdaQueryWrapper<TopHoldersSummaryDO> getReportExists(String symbol, String reportName) {
        LambdaQueryWrapper<TopHoldersSummaryDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TopHoldersSummaryDO::getSymbol, symbol)
                .eq(TopHoldersSummaryDO::getReportName, reportName)
                .eq(TopHoldersSummaryDO::getIsDeleted, false);
        return queryWrapper;
    }
}
