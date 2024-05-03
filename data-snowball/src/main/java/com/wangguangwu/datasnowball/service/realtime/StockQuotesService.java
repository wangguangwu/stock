package com.wangguangwu.datasnowball.service.realtime;

import com.wangguangwu.datasnowball.entity.StockQuotesInfoDO;

import java.util.List;

/**
 * 股票行情服务
 *
 * @author wangguangwu
 */
public interface StockQuotesService {

    /**
     * 保存股票行情
     *
     * @param symbol 股票代码
     * @param list   股票行情数据
     * @return 是否保存成功
     */
    boolean stockQuotesSave(String symbol, List<StockQuotesInfoDO> list);

}
