package com.wangguangwu.datasnowball.service.f10.impl;

import com.wangguangwu.datasnowball.service.f10.F10FetchService;
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
        return fetchService.industryFetch(symbol);
    }

    @Override
    public String holders(String symbol) {
        return fetchService.holdersFetch(symbol);
    }

    @Override
    public String bonus(String symbol, int page, int size) {
        return fetchService.bonusFetch(symbol, page, size);
    }

    @Override
    public String orgHoldingChange(String symbol) {
        return fetchService.orgHoldingChangeFetch(symbol);
    }

    @Override
    public String industryCompare(String symbol) {
        return fetchService.industryCompareFetch(symbol);
    }

    @Override
    public String businessAnalysis(String symbol) {
        return fetchService.businessAnalysisFetch(symbol);
    }

    @Override
    public String sharesChg(String symbol, int count) {
        return fetchService.sharesChgFetch(symbol, count);
    }

    @Override
    public boolean topHolders(String symbol, int circula) {
        String json = fetchService.topHoldersFetch(symbol, circula);
        return saveService.topHoldersSave(symbol, json);
    }

    @Override
    public String mainIndicator(String symbol) {
        // TODO：获取财务指标信息。
        return fetchService.mainIndicatorFetch(symbol);
    }
}
