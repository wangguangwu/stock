package com.wangguangwu.datatushare.controller;

import com.wangguangwu.datatushare.service.stock.StockService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguangwu
 */
@RestController
@Slf4j
@RequestMapping("stock")
public class StockController {

    @Resource
    private StockService stockService;

    /**
     * 根据股票代码更新股票数据
     *
     * @return 操作是否成功
     */
    @PostMapping("/updateBasicInfo")
    public Boolean updateBasicInfo() {
        return stockService.stockBasicItem();
    }

}
