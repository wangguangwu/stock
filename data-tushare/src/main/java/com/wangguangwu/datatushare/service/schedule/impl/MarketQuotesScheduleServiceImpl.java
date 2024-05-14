package com.wangguangwu.datatushare.service.schedule.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSON;
import com.wangguangwu.datatushare.component.StockOperationComponent;
import com.wangguangwu.datatushare.service.quotes.MarketQuotesService;
import com.wangguangwu.datatushare.service.schedule.MarketQuotesScheduleService;
import com.wangguangwu.datatushare.util.DateFormatUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class MarketQuotesScheduleServiceImpl implements MarketQuotesScheduleService {

    @Resource
    private StockOperationComponent stockOperationComponent;
    @Resource
    private MarketQuotesService marketQuotesService;

    @Override
    public void updateDaily() {
        Set<String> tsCodeList = stockOperationComponent.getTsCodeList();
        if (CollUtil.isEmpty(tsCodeList)) {
            log.info("没有需要查询的股票代码");
            return;
        }
        List<String> errorTsCodeList = new ArrayList<>();
        for (int i = 0; i < 90; i++) {
            String date = DateFormatUtil.formatYYYYMMDD(i);
            tsCodeList.forEach(tsCode -> {
                try {
                    boolean succeed = marketQuotesService.dailyMarketQuotes(tsCode, date, date, date);
                    if (!succeed) {
                        errorTsCodeList.add(tsCode);
                    }
                } catch (Exception e) {
                    errorTsCodeList.add(tsCode);
                }
            });
        }
        if (CollUtil.isNotEmpty(errorTsCodeList)) {
            log.info("更新日行情失败: {}", JSON.toJSON(errorTsCodeList));
        }
    }
}
