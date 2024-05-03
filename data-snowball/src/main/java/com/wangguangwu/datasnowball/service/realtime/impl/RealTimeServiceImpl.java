package com.wangguangwu.datasnowball.service.realtime.impl;

import com.wangguangwu.datasnowball.service.realtime.RealTimeFetchService;
import com.wangguangwu.datasnowball.service.realtime.RealTimeSaveService;
import com.wangguangwu.datasnowball.service.realtime.RealTimeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class RealTimeServiceImpl implements RealTimeService {

    @Resource
    private RealTimeFetchService realTimeFetchService;
    @Resource
    private RealTimeSaveService realTimeSaveService;

    @Override
    public boolean kline(String symbol, int days) {
        String json = realTimeFetchService.klineFetch(symbol, days);
        return realTimeSaveService.klineSave(symbol, json);
    }
}
