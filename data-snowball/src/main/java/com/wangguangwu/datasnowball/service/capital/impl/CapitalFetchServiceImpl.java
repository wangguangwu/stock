package com.wangguangwu.datasnowball.service.capital.impl;

import com.wangguangwu.datasnowball.component.HttpFetcherComponent;
import com.wangguangwu.datasnowball.constant.CapitalUrlConstant;
import com.wangguangwu.datasnowball.service.capital.CapitalFetchService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class CapitalFetchServiceImpl implements CapitalFetchService {

    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_COUNT = 20;
    private static final int DEFAULT_MAX_SIZE = 180;
    private static final int DEFAULT_MIN_SIZE = 30;

    @Resource
    private HttpFetcherComponent fetcherComponent;

    @Override
    public String margin(String symbol, int page, int size) {
        String url = buildUrl(CapitalUrlConstant.CAPITAL_MARGIN_URL, symbol, page, size);
        return fetcherComponent.fetchWithoutToken(url);
    }

    @Override
    public String blockTrans(String symbol, int page, int size) {
        String url = buildUrl(CapitalUrlConstant.CAPITAL_BLOCK_TRANS_URL, symbol, page, size == 0 ? DEFAULT_MIN_SIZE : size);
        return fetcherComponent.fetchWithoutToken(url);
    }

    @Override
    public String assort(String symbol) {
        return fetcherComponent.fetchWithoutToken(CapitalUrlConstant.CAPITAL_ASSORT_URL + symbol);
    }

    @Override
    public String flow(String symbol) {
        return fetcherComponent.fetchWithoutToken(CapitalUrlConstant.CAPITAL_FLOW_URL + symbol);
    }

    @Override
    public String history(String symbol, int count) {
        String url = CapitalUrlConstant.CAPITAL_HISTORY_URL + symbol
                + "&count=" + (count == 0 ? DEFAULT_COUNT : count);
        return fetcherComponent.fetchWithoutToken(url);
    }

    //=====================================私有方法==========================================

    public String buildUrl(String baseUrl, String symbol, int page, int size) {
        return baseUrl + symbol +
                "&page=" + (page == 0 ? DEFAULT_PAGE : page) +
                "&size=" + (size == 0 ? DEFAULT_MAX_SIZE : size);
    }
}
