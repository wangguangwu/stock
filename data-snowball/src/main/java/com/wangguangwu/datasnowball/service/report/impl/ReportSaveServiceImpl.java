package com.wangguangwu.datasnowball.service.report.impl;

import com.wangguangwu.datasnowball.service.report.ReportSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class ReportSaveServiceImpl implements ReportSaveService {

    @Override
    public boolean latestSave(String symbol, String json) {
        return false;
    }

    @Override
    public boolean earningForecastSave(String symbol, String json) {
        return false;
    }
}
