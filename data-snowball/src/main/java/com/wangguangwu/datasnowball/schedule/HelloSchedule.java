package com.wangguangwu.datasnowball.schedule;

import com.wangguangwu.datasnowball.service.schedule.HelloScheduleService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangguangwu
 */
@Component
public class HelloSchedule {

    @Resource
    private HelloScheduleService helloScheduleService;

    @Scheduled(cron = "0 55 0 ? * *")
    public void updateTradeInfo() {
        helloScheduleService.updateTradeInfo();
    }
}
