package com.wangguangwu.datasnowball.service.finance.impl;

import com.wangguangwu.datasnowball.component.HttpFetcherComponent;
import com.wangguangwu.datasnowball.constant.FinanceUrlConstant;
import com.wangguangwu.datasnowball.service.finance.FinanceFetchService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class FinanceFetchServiceImpl implements FinanceFetchService {

    @Resource
    private HttpFetcherComponent fetcherComponent;

    @Override
    public String caseFlow(String symbol, int isAnnals, int count) {
        return fetchData(FinanceUrlConstant.FINANCE_CASH_FLOW_URL, symbol, isAnnals, count);
    }

    public String indicator(String symbol, int isAnnals, int count) {
        return fetchData(FinanceUrlConstant.FINANCE_INDICATOR_URL, symbol, isAnnals, count);
    }

    public String balance(String symbol, int isAnnals, int count) {
        return fetchData(FinanceUrlConstant.FINANCE_BALANCE_URL, symbol, isAnnals, count);
    }

    public String income(String symbol, int isAnnals, int count) {
        return fetchData(FinanceUrlConstant.FINANCE_INCOME_URL, symbol, isAnnals, count);
    }

    public String business(String symbol, int isAnnals, int count) {
        return fetchData(FinanceUrlConstant.FINANCE_BUSINESS_URL, symbol, isAnnals, count);
    }

    //=====================================私有方法==========================================

    private String fetchData(String baseUrl, String symbol, int isAnnals, int count) {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);
        urlBuilder.append(symbol);

        if (isAnnals == 1) {
            urlBuilder.append("&type=Q4");
        }

        urlBuilder.append("&count=").append(count);

        return fetcherComponent.fetchWithoutToken(urlBuilder.toString());
    }
}
