package com.wangguangwu.datasnowball.service.f10.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datasnowball.entity.MainIndicatorItemDO;
import com.wangguangwu.datasnowball.service.basic.MainIndicatorItemService;
import com.wangguangwu.datasnowball.service.f10.MainIndicatorService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class MainIndicatorServiceImpl implements MainIndicatorService {

    @Resource
    private MainIndicatorItemService mainIndicatorItemService;

    @Override
    public Set<String> listExistsReports(String symbol) {
        LambdaQueryWrapper<MainIndicatorItemDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MainIndicatorItemDO::getSymbol, symbol)
                .eq(MainIndicatorItemDO::getIsDeleted, false)
                .select(MainIndicatorItemDO::getReportDate);

        return mainIndicatorItemService.list(queryWrapper)
                .stream()
                .map(MainIndicatorItemDO::getReportDate)
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveMainIndicators(List<MainIndicatorItemDO> mainIndicatorItemDOList) {
        return mainIndicatorItemService.saveBatch(mainIndicatorItemDOList);
    }
}
