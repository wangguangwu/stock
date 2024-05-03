package com.wangguangwu.datasnowball.service.f10.impl;

import com.wangguangwu.datasnowball.service.f10.F10FetchService;
import com.wangguangwu.datasnowball.service.f10.F10QueryService;
import com.wangguangwu.datasnowball.service.f10.F10SaveService;
import com.wangguangwu.datasnowball.service.f10.F10Service;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class F10ServiceImpl implements F10Service {

    @Resource
    private F10QueryService queryService;
    @Resource
    private F10FetchService fetchService;
    @Resource
    private F10SaveService saveService;

    @Override
    public String skHolderChg(String symbol) {
        return fetchService.skHolderChgFetch(symbol);
    }

    @Override
    public String skHolder(String symbol) {
        String json = fetchService.skHolderFetch(symbol);
        saveService.skHolderSave(json);
        return json;
    }

    @Override
    public String industry(String symbol) {
        return null;
    }

    @Override
    public String holders(String symbol) {
        return null;
    }

    @Override
    public String bonus(String symbol, int page, int size) {
        return null;
    }

    @Override
    public String orgHoldingChange(String symbol) {
        return null;
    }

    @Override
    public String industryCompare(String symbol) {
        return null;
    }

    @Override
    public String businessAnalysis(String symbol) {
        return null;
    }

    @Override
    public String sharesChg(String symbol, int count) {
        return null;
    }

    @Override
    public boolean topHolders(String symbol, int circula) {
        boolean needUpdated = queryService.topHoldersQuery(symbol);
        if (needUpdated) {
            String json = fetchService.topHoldersFetch(symbol, circula);
            return saveService.topHoldersSave(symbol, json);
        }
        return true;
    }

    @Override
    public String mainIndicator(String symbol) {
        return null;
    }
}
