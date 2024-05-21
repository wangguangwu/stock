package com.wangguangwu.datatushare.service.schedule.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSON;
import com.wangguangwu.datatushare.component.StockOperationComponent;
import com.wangguangwu.datatushare.service.finance.DividendService;
import com.wangguangwu.datatushare.service.schedule.FinanceScheduleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class FinanceScheduleServiceImpl implements FinanceScheduleService {

    @Resource
    private StockOperationComponent stockOperationComponent;
    @Resource
    private DividendService dividendService;

    @Override
    public void updateDividend() {
        Set<String> tsCodeList = stockOperationComponent.getTsCodeList();
        if (CollUtil.isEmpty(tsCodeList)) {
            log.info("没有需要查询的股票代码");
            return;
        }

        List<String> errorTsCodeList = Collections.synchronizedList(new ArrayList<>());
        AtomicInteger remainingCounter = new AtomicInteger(tsCodeList.size());

        tsCodeList.parallelStream().forEach(tsCode -> {
            try {
                boolean succeed = dividendService.dividend(tsCode);
                if (!succeed) {
                    errorTsCodeList.add(tsCode);
                }
            } catch (Exception e) {
                log.error("处理股票代码 [{}] 时发生异常", tsCode, e);
                errorTsCodeList.add(tsCode);
            } finally {
                int remaining = remainingCounter.decrementAndGet();
                log.debug("剩余[{}]个股票未拉取", remaining);
            }
        });

        if (!errorTsCodeList.isEmpty()) {
            log.info("更新分红送股失败: {}", JSON.toJSON(errorTsCodeList));
        }
    }
}
