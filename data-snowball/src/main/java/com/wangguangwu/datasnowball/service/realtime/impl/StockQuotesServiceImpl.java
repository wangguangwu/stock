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
        List<LocalDate> tradeDateList = list.stream().map(StockQuotesInfoDO::getTradeDate).toList();
        LambdaQueryWrapper<StockQuotesInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StockQuotesInfoDO::getSymbol, symbol)
                .eq(StockQuotesInfoDO::getIsDeleted, false)
                .in(StockQuotesInfoDO::getTradeDate, tradeDateList);
        List<LocalDate> existTradeDateList = stockQuotesInfoService.list().stream().map(StockQuotesInfoDO::getTradeDate)
                .toList();
        // 过滤存在的数据
        list = list.stream().filter(stockQuotesInfoDO -> !existTradeDateList.contains(stockQuotesInfoDO.getTradeDate())).toList();

        return stockQuotesInfoService.saveBatch(list);
    }
}
