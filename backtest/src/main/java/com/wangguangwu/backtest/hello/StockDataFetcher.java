package com.wangguangwu.backtest.hello;

/**
 * @author wangguangwu
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockDataFetcher {

    public static List<Double[]> getStockData(String stockCode, String startDate) throws IOException {
// 模拟获取股票数据，这里返回随机生成的数据
        List<Double[]> stockData = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            stockData.add(new Double[]{(double) i, 100.0 + i, 105.0 + i, 95.0 + i, 102.0 + i, 1000.0 + i * 10});
        }
        return stockData;
    }
}

