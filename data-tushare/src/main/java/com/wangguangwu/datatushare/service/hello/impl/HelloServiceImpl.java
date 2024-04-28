package com.wangguangwu.datatushare.service.hello.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datatushare.entity.StockBasicInfoDO;
import com.wangguangwu.datatushare.service.basic.StockBasicInfoService;
import com.wangguangwu.datatushare.service.hello.HelloService;
import com.wangguangwu.datatushare.service.quotes.MarketQuotesService;
import com.wangguangwu.datatushare.util.DateFormatUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Resource
    private StockBasicInfoService stockBasicInfoService;

    @Resource
    private MarketQuotesService marketQuotesService;

    @Override
    public void hello() {
        LambdaQueryWrapper<StockBasicInfoDO> queryWrapper = new LambdaQueryWrapper<>(StockBasicInfoDO.class);
        queryWrapper.eq(StockBasicInfoDO::getMarket, "主板")
                .eq(StockBasicInfoDO::getIsDeleted, Boolean.FALSE);

        List<StockBasicInfoDO> list = stockBasicInfoService.list(queryWrapper);
        if (CollUtil.isEmpty(list)) {
            return;
        }
        Set<String> tsCodeSet = list.stream().map(StockBasicInfoDO::getTsCode).collect(Collectors.toSet());
        String date = DateFormatUtil.formatYYYYMMDD();
        for (String tsCode : tsCodeSet) {
            marketQuotesService.dailyBasic(tsCode, date, date);
        }
    }
}
