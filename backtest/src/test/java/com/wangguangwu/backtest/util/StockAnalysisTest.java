package com.wangguangwu.backtest.util;

import com.wangguangwu.backtest.hello.ChartDrawer;
import com.wangguangwu.backtest.hello.IndicatorCalculator;
import com.wangguangwu.backtest.hello.StockDataFetcher;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author wangguangwu
 */
public class StockAnalysisTest {

    @Test
    public void testStockDataFetcher() throws IOException {
        List<Double[]> stockData = StockDataFetcher.getStockData("603986", "2019-01-01");
    }

    @Test
    public void testIndicatorCalculator() throws IOException {
        List<Double[]> stockData = StockDataFetcher.getStockData("603986", "2019-01-01");
        List<Double[]> macdData = IndicatorCalculator.calculateMACD(stockData);
        List<Double[]> kdjData = IndicatorCalculator.calculateKDJ(stockData);
    }

    @Test
    public void testChartDrawer() throws IOException {
        List<Double[]> stockData = StockDataFetcher.getStockData("603986", "2019-01-01");
        List<Double[]> macdData = IndicatorCalculator.calculateMACD(stockData);
        List<Double[]> kdjData = IndicatorCalculator.calculateKDJ(stockData);

        String filePath = "/Users/wangguangwu/Desktop/company/macd.jpg";
        try {
            ChartDrawer.drawChart(stockData, macdData, kdjData, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}