package com.wangguangwu.datatushare.service;

import com.wangguangwu.datatushare.entity.StockBasicInfoDO;

import java.util.List;

/**
 * 事务服务
 *
 * @author wangguangwu
 */
public interface StockTransactionService {

    /**
     * 保存股票基本信息
     *
     * @param stockBasicInfoDOList 股票基本信息
     */
    void saveStockBasicItem(List<StockBasicInfoDO> stockBasicInfoDOList);

}
