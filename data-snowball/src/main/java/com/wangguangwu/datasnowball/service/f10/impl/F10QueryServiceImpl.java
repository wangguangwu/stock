package com.wangguangwu.datasnowball.service.f10.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datasnowball.entity.TopHoldersSummaryDO;
import com.wangguangwu.datasnowball.service.basic.TopHoldersSummaryService;
import com.wangguangwu.datasnowball.service.f10.F10QueryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class F10QueryServiceImpl implements F10QueryService {

    @Resource
    private TopHoldersSummaryService summaryService;

    @Override
    public boolean topHoldersQuery(String symbol) {
        LambdaQueryWrapper<TopHoldersSummaryDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TopHoldersSummaryDO::getSymbol, symbol)
                .eq(TopHoldersSummaryDO::getIsDeleted, false);
        return summaryService.count(queryWrapper) == 0;
    }
}
