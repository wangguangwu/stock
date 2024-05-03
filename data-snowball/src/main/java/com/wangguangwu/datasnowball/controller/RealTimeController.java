package com.wangguangwu.datasnowball.controller;

import com.wangguangwu.datasnowball.service.realtime.RealTimeFetchService;
import com.wangguangwu.datasnowball.service.realtime.RealTimeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("realTime")
public class RealTimeController {

    @Resource
    private RealTimeService realTimeService;

    /**
     * 获取股票的 K 线图。
     *
     * @param symbol 股票代码
     * @param days   时间周期
     * @return K 线图
     */
    @GetMapping("/kline")
    public boolean kline(String symbol, @RequestParam(defaultValue = "90") int days) {
        return realTimeService.kline(symbol, days);
    }

}
