package com.wangguangwu.datasnowball.schedule;

import com.wangguangwu.datasnowball.service.schedule.F10ScheduleService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangguangwu
 */
@Component
public class F10Schedule {

    @Resource
    private F10ScheduleService f10ScheduleService;

    @Scheduled(cron = "0 26 01 ? * *")
    public void updateTopHolders() {
        f10ScheduleService.updateTopHolders();
    }

}
