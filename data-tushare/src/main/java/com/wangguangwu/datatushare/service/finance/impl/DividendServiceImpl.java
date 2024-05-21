package com.wangguangwu.datatushare.service.finance.impl;

import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.component.finance.DividendComponent;
import com.wangguangwu.datatushare.service.finance.DividendService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class DividendServiceImpl implements DividendService {

    @Resource
    private DividendComponent dividendComponent;

    @Override
    public boolean dividend(String symbol) {
        dividendComponent.setParams(getParams(symbol));
        return dividendComponent.fetchAndSaveData("A股分红送权");
    }

    private static JSONObject getParams(String tsCode) {
        JSONObject params = new JSONObject();
        params.set("ts_code", tsCode);
        return params;
    }
}
