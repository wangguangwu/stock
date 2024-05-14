package com.wangguangwu.datatushare.schedule;

import com.wangguangwu.datatushare.service.schedule.MarketQuotesScheduleService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangguangwu
 */
@Component
public class MarketQuotesSchedule {

    @Resource
    private MarketQuotesScheduleService marketQuotesScheduleService;

    @Scheduled(cron = "0 41 20 ? * *")
    public void updateDaily() {
        marketQuotesScheduleService.updateDaily();
    }

}
