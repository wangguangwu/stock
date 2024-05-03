package com.wangguangwu.datasnowball.service.f10.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datasnowball.entity.TopHoldersItemDO;
import com.wangguangwu.datasnowball.entity.TopHoldersQuitDO;
import com.wangguangwu.datasnowball.entity.TopHoldersSummaryDO;
import com.wangguangwu.datasnowball.mapper.TopHolderMapper;
import com.wangguangwu.datasnowball.service.basic.TopHoldersItemService;
import com.wangguangwu.datasnowball.service.basic.TopHoldersQuitService;
import com.wangguangwu.datasnowball.service.basic.TopHoldersSummaryService;
import com.wangguangwu.datasnowball.service.f10.TopHolderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class TopHolderServiceImpl implements TopHolderService {

    @Resource
    private TransactionTemplate transactionTemplate;
    @Resource
    private TopHoldersSummaryService topHoldersSummaryService;
    @Resource
    private TopHoldersItemService topHoldersItemService;
    @Resource
    private TopHoldersQuitService topHoldersQuitService;
    @Resource
    private TopHolderMapper topHolderMapper;

    @Override
    public boolean existReport(String symbol, String reportName) {
        return topHoldersSummaryService.count(getReportExists(symbol, reportName)) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveTopHolderMessages(TopHoldersSummaryDO topHoldersSummaryDO, List<TopHoldersItemDO> topHoldersItemDOList, List<TopHoldersQuitDO> topHoldersQuitDOList) {
        return Boolean.TRUE.equals(transactionTemplate.execute(status -> {
            Integer summaryId = getSummaryId(topHoldersSummaryDO);
            if (summaryId == null) {
                return false;
            }

            boolean itemsSaved = processItemList(topHoldersItemDOList, summaryId);
            boolean quitsSaved = processQuitList(topHoldersQuitDOList, summaryId);

            if (!itemsSaved || !quitsSaved) {
                status.setRollbackOnly();
                return false;
            }
            return true;
        }));
    }

    @Override
    public List<String> listTopHolderInfo(String holderName, String market) {
        return topHolderMapper.listTopHolderInfo(holderName, market);
    }

    private boolean processItemList(List<TopHoldersItemDO> items, Integer summaryId) {
        if (CollUtil.isEmpty(items)) {
            return true;
        }
        items.forEach(item -> item.setSummaryId(summaryId));
        return topHoldersItemService.saveBatch(items);
    }

    private boolean processQuitList(List<TopHoldersQuitDO> quits, Integer summaryId) {
        if (CollUtil.isEmpty(quits)) {
            return true;
        }
        quits.forEach(quit -> quit.setSummaryId(summaryId));
        return topHoldersQuitService.saveBatch(quits);
    }

    private Integer getSummaryId(TopHoldersSummaryDO topHoldersSummaryDO) {
        boolean save = topHoldersSummaryService.save(topHoldersSummaryDO);
        if (!save) {
            return null;
        }
        List<TopHoldersSummaryDO> summaryDOList = topHoldersSummaryService.list(getReportExists(topHoldersSummaryDO.getSymbol(), topHoldersSummaryDO.getReportName()));

        return summaryDOList.stream().findFirst().map(TopHoldersSummaryDO::getId).orElse(null);
    }

    private static LambdaQueryWrapper<TopHoldersSummaryDO> getReportExists(String symbol, String reportName) {
        LambdaQueryWrapper<TopHoldersSummaryDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TopHoldersSummaryDO::getSymbol, symbol).eq(TopHoldersSummaryDO::getReportName, reportName).eq(TopHoldersSummaryDO::getIsDeleted, false);
        return queryWrapper;
    }
}
