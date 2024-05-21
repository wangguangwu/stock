package com.wangguangwu.datatushare.schedule;

import com.wangguangwu.datatushare.service.schedule.FinanceScheduleService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangguangwu
 */
@Component
public class FinanceSchedule {

    @Resource
    private FinanceScheduleService financeScheduleService;

    @Scheduled(cron = "0 59 17 ? * *")
    public void updateDaily() {
        financeScheduleService.updateDividend();
    }
}

