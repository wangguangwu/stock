package com.wangguangwu.datasnowball.service.realtime.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datasnowball.entity.StockQuotesInfoDO;
import com.wangguangwu.datasnowball.service.basic.StockQuotesInfoService;
import com.wangguangwu.datasnowball.service.realtime.StockQuotesService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class StockQuotesServiceImpl implements StockQuotesService {

    @Resource
    private StockQuotesInfoService stockQuotesInfoService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean stockQuotesSave(String symbol, List<StockQuotesInfoDO> list) {
        if (CollUtil.isEmpty(list)) {
            // 说明没有数据，不表示错误
            return true;
        }

        List<LocalDate> tradeDateList = list.stream().map(StockQuotesInfoDO::getTradeDate).distinct().toList();

        LambdaQueryWrapper<StockQuotesInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StockQuotesInfoDO::getSymbol, symbol).eq(StockQuotesInfoDO::getIsDeleted, false).in(StockQuotesInfoDO::getTradeDate, tradeDateList);

        Set<LocalDate> existTradeDateList = stockQuotesInfoService.list(queryWrapper).stream().map(StockQuotesInfoDO::getTradeDate).collect(Collectors.toSet());

        // 过滤存在的数据
        list = list.stream().filter(stockQuotesInfoDO -> !existTradeDateList.contains(stockQuotesInfoDO.getTradeDate())).toList();
        if (CollUtil.isEmpty(list)) {
            return true;
        }

        return stockQuotesInfoService.saveBatch(list);
    }
}
