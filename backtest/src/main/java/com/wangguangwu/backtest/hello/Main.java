package com.wangguangwu.backtest.hello;

import java.io.IOException;
import java.util.List;

/**
 * @author wangguangwu
 */
public class Main {
    public static void main(String[] args) {
        try {
            List<Double[]> stockData = StockDataFetcher.getStockData("603986", "2019-01-01");
            List<Double[]> macdData = IndicatorCalculator.calculateMACD(stockData);
            List<Double[]> kdjData = IndicatorCalculator.calculateKDJ(stockData);

            String filePath = "/Users/wangguangwu/Desktop/company/macd.jpg";
            ChartDrawer.drawChart(stockData, macdData, kdjData, filePath);

            System.out.println("Chart saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
