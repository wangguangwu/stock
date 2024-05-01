package com.wangguangwu.datasnowball.service.f10.impl;

import com.wangguangwu.datasnowball.component.HttpFetcherComponent;
import com.wangguangwu.datasnowball.constant.F10UrlConstant;
import com.wangguangwu.datasnowball.service.f10.F10FetchService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class F10FetchServiceImpl implements F10FetchService {

    private static final Integer DEFAULT_PAGE = 1;
    private static final Integer DEFAULT_SIZE = 10;
    private static final Integer DEFAULT_COUNT = 5;
    private static final Integer DEFAULT_CIRCULA = 1;

    @Resource
    private HttpFetcherComponent fetcherComponent;

    @Override
    public String skHolderChgFetch(String symbol) {
        return fetcherComponent.fetch(F10UrlConstant.F10_SK_HOLDER_CHG + symbol);
    }

    @Override
    public String skHolderFetch(String symbol) {
        return fetcherComponent.fetch(F10UrlConstant.F10_SK_HOLDER + symbol);
    }

    @Override
    public String industryFetch(String symbol) {
        return fetcherComponent.fetch(F10UrlConstant.F10_INDUSTRY + symbol);

    }

    @Override
    public String holdersFetch(String symbol) {
        return fetcherComponent.fetch(F10UrlConstant.F10_HOLDERS + symbol);
    }

    @Override
    public String bonusFetch(String symbol, int page, int size) {
        String url = F10UrlConstant.F10_BONUS + symbol + "&page=" + (page == 0 ? DEFAULT_PAGE : page) + "&size=" + (size == 0 ? DEFAULT_SIZE : size);
        return fetcherComponent.fetch(url);

    }

    @Override
    public String orgHoldingChangeFetch(String symbol) {
        return fetcherComponent.fetch(F10UrlConstant.F10_ORG_HOLDING_CHANGE + symbol);

    }

    @Override
    public String industryCompareFetch(String symbol) {
        String url = F10UrlConstant.F10_INDUSTRY_COMPARE + symbol;
        return fetcherComponent.fetch(url);

    }

    @Override
    public String businessAnalysisFetch(String symbol) {
        return fetcherComponent.fetch(F10UrlConstant.F10_BUSINESS_ANALYSIS + symbol);

    }

    @Override
    public String sharesChgFetch(String symbol, int count) {
        String url = F10UrlConstant.F10_SHARES_CHG + symbol + "&count=" + (count == 0 ? DEFAULT_COUNT : count);
        return fetcherComponent.fetch(url);

    }

    @Override
    public String topHoldersFetch(String symbol, int circula) {
        String url = F10UrlConstant.F10_TOP_HOLDERS + symbol + "&circula=" + (circula == 0 ? DEFAULT_CIRCULA : circula);
        return fetcherComponent.fetch(url);

    }

    @Override
    public String mainIndicatorFetch(String symbol) {
        return fetcherComponent.fetch(F10UrlConstant.F10_INDICATOR + symbol);
    }
}
