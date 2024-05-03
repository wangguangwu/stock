package com.wangguangwu.datasnowball.controller;

import com.wangguangwu.datasnowball.service.f10.F10Service;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("f10")
public class F10Controller {

    @Resource
    private F10Service f10Service;

    @GetMapping("/skHolderChg/{symbol}")
    public String getSkHolderChg(@PathVariable String symbol) {
        return f10Service.skHolderChg(symbol);
    }

    @GetMapping("/skHolder/{symbol}")
    public String getSkHolder(@PathVariable String symbol) {
        return f10Service.skHolder(symbol);
    }

    @GetMapping("/industry/{symbol}")
    public String getIndustry(@PathVariable String symbol) {
        return f10Service.industry(symbol);
    }

    @GetMapping("/holders/{symbol}")
    public String getHolders(@PathVariable String symbol) {
        return f10Service.holders(symbol);
    }

    @GetMapping("/bonus/{symbol}")
    public String getBonus(@PathVariable String symbol, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return f10Service.bonus(symbol, page, size);
    }

    @GetMapping("/orgHoldingChange/{symbol}")
    public String getOrgHoldingChange(@PathVariable String symbol) {
        return f10Service.orgHoldingChange(symbol);
    }

    @GetMapping("/industryCompare/{symbol}")
    public String getIndustryCompare(@PathVariable String symbol) {
        return f10Service.industryCompare(symbol);
    }

    @GetMapping("/businessAnalysis/{symbol}")
    public String getBusinessAnalysis(@PathVariable String symbol) {
        return f10Service.businessAnalysis(symbol);
    }

    @GetMapping("/sharesChg/{symbol}")
    public String getSharesChg(@PathVariable String symbol, @RequestParam(defaultValue = "5") int count) {
        return f10Service.sharesChg(symbol, count);
    }

    @GetMapping("/topHolders/{symbol}")
    public boolean getTopHolders(@PathVariable String symbol, @RequestParam(defaultValue = "1") int circula) {
        return f10Service.topHolders(symbol, circula);
    }

    @GetMapping("/mainIndicator/{symbol}")
    public String getMainIndicator(@PathVariable String symbol) {
        return f10Service.mainIndicator(symbol);
    }
}
