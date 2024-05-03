package com.wangguangwu.datasnowball.service.schedule.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datasnowball.entity.StockBasicInfoDO;
import com.wangguangwu.datasnowball.service.basic.StockBasicInfoService;
import com.wangguangwu.datasnowball.service.f10.F10Service;
import com.wangguangwu.datasnowball.service.schedule.F10ScheduleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class F10ScheduleServiceImpl implements F10ScheduleService {

    @Resource
    private F10Service f10Service;
    @Resource
    private StockBasicInfoService stockBasicInfoService;

    @Override
    public void updateTopHolders() {
        LambdaQueryWrapper<StockBasicInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StockBasicInfoDO::getIsDeleted, false);
        List<String> symbolList = stockBasicInfoService.list(queryWrapper).stream().map(StockBasicInfoDO::getSymbol).toList();
        if (CollUtil.isEmpty(symbolList)) {
            return;
        }
        Map<String, Boolean> symbolMap = new HashMap<>();
        symbolList.forEach(symbol -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                boolean succeed = f10Service.topHolders(symbol, 1);
                symbolMap.put(symbol, succeed);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(symbolMap);
    }
}
