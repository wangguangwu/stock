package com.wangguangwu.datasnowball.controller;

import com.wangguangwu.datasnowball.service.finance.FinanceFetchService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangguangwu
 */

@RestController
public class FinanceController {

    @Resource
    private FinanceFetchService financeFetchService;

    @GetMapping("/cashFlow")
    public String getCashFlow(
            @RequestParam("symbol") String symbol,
            @RequestParam(value = "isAnnals", defaultValue = "0") int isAnnals,
            @RequestParam(value = "count", defaultValue = "1") int count) {
        return financeFetchService.caseFlowFetch(symbol, isAnnals, count);
    }

    @GetMapping("/indicators")
    public String getFinancialIndicators(
            @RequestParam("symbol") String symbol,
            @RequestParam(value = "isAnnals", defaultValue = "0") int isAnnals,
            @RequestParam(value = "count", defaultValue = "1") int count) {
        return financeFetchService.indicatorFetch(symbol, isAnnals, count);
    }

    @GetMapping("/balanceSheet")
    public String getBalanceSheet(
            @RequestParam("symbol") String symbol,
            @RequestParam(value = "isAnnals", defaultValue = "0") int isAnnals,
            @RequestParam(value = "count", defaultValue = "1") int count) {
        return financeFetchService.balanceFetch(symbol, isAnnals, count);
    }

    @GetMapping("/incomeStatement")
    public String getIncomeStatement(
            @RequestParam("symbol") String symbol,
            @RequestParam(value = "isAnnals", defaultValue = "0") int isAnnals,
            @RequestParam(value = "count", defaultValue = "1") int count) {
        return financeFetchService.incomeFetch(symbol, isAnnals, count);
    }

    @GetMapping("/businessOverview")
    public String getBusinessOverview(
            @RequestParam("symbol") String symbol,
            @RequestParam(value = "isAnnals", defaultValue = "0") int isAnnals,
            @RequestParam(value = "count", defaultValue = "1") int count) {
        return financeFetchService.businessFetch(symbol, isAnnals, count);
    }
}

