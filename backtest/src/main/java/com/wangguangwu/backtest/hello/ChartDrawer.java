package com.wangguangwu.backtest.hello;


import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ChartDrawer {

    public static void drawChart(List<Double[]> stockData, List<Double[]> macdData, List<Double[]> kdjData, String filePath) throws IOException {
        // 创建K线图数据集
        DefaultHighLowDataset kLineDataset = createKLineDataset(stockData);

        // 创建MACD数据集
        XYSeriesCollection macdDataset = createMACDDataset(macdData);

        // 创建KDJ数据集
        XYSeriesCollection kdjDataset = createKDJDataset(kdjData);

        // 创建K线图
        XYPlot kLinePlot = new XYPlot(kLineDataset, null, new NumberAxis("Price"), new CandlestickRenderer());
        kLinePlot.setBackgroundPaint(java.awt.Color.BLACK);

        // 创建成交量图
        XYPlot volumePlot = new XYPlot(createVolumeDataset(stockData), null, new NumberAxis("Volume"), new StandardXYItemRenderer());
        volumePlot.setBackgroundPaint(java.awt.Color.BLACK);

        // 创建MACD图
        XYPlot macdPlot = new XYPlot(macdDataset, null, new NumberAxis("MACD"), new StandardXYItemRenderer());
        macdPlot.setBackgroundPaint(java.awt.Color.BLACK);

        // 创建KDJ图
        XYPlot kdjPlot = new XYPlot(kdjDataset, null, new NumberAxis("KDJ"), new StandardXYItemRenderer());
        kdjPlot.setBackgroundPaint(java.awt.Color.BLACK);

        // 将所有子图添加到组合图中
        CombinedDomainXYPlot combinedPlot = new CombinedDomainXYPlot(new DateAxis("Date"));
        combinedPlot.add(kLinePlot, 3);
        combinedPlot.add(volumePlot, 1);
        combinedPlot.add(macdPlot, 1);
        combinedPlot.add(kdjPlot, 1);
        combinedPlot.setGap(10.0);

        JFreeChart chart = new JFreeChart("Stock Analysis", JFreeChart.DEFAULT_TITLE_FONT, combinedPlot, true);

        // 保存图表为文件
        ChartUtils.saveChartAsJPEG(new File(filePath), chart, 1600, 900);
    }

    private static DefaultHighLowDataset createKLineDataset(List<Double[]> stockData) {
        // Convert stockData to the required format for DefaultHighLowDataset
        int itemCount = stockData.size();
        Date[] dates = new Date[itemCount];
        double[] highs = new double[itemCount];
        double[] lows = new double[itemCount];
        double[] opens = new double[itemCount];
        double[] closes = new double[itemCount];
        double[] volumes = new double[itemCount];

        for (int i = 0; i < itemCount; i++) {
            Double[] item = stockData.get(i);
            dates[i] = new Date((long) (item[0] * 24 * 60 * 60 * 1000)); // Convert to Date
            opens[i] = item[1];
            closes[i] = item[2];
            highs[i] = item[3];
            lows[i] = item[4];
            volumes[i] = item[5];
        }

        return new DefaultHighLowDataset("K-Line", dates, highs, lows, opens, closes, volumes);
    }

    private static XYSeriesCollection createMACDDataset(List<Double[]> macdData) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries difSeries = new XYSeries("DIF");
        XYSeries deaSeries = new XYSeries("DEA");
        XYSeries histSeries = new XYSeries("Histogram");

        for (int i = 0; i < macdData.size(); i++) {
            difSeries.add(i, macdData.get(i)[0]); // DIF
            deaSeries.add(i, macdData.get(i)[1]); // DEA
            histSeries.add(i, macdData.get(i)[2]); // Histogram
        }

        dataset.addSeries(difSeries);
        dataset.addSeries(deaSeries);
        dataset.addSeries(histSeries);

        return dataset;
    }

    private static XYSeriesCollection createKDJDataset(List<Double[]> kdjData) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries kSeries = new XYSeries("K");
        XYSeries dSeries = new XYSeries("D");
        XYSeries jSeries = new XYSeries("J");

        for (int i = 0; i < kdjData.size(); i++) {
            kSeries.add(i, kdjData.get(i)[0]);
            dSeries.add(i, kdjData.get(i)[1]);
            jSeries.add(i, kdjData.get(i)[2]);
        }

        dataset.addSeries(kSeries);
        dataset.addSeries(dSeries);
        dataset.addSeries(jSeries);

        return dataset;
    }

    private static XYSeriesCollection createVolumeDataset(List<Double[]> stockData) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries volumeSeries = new XYSeries("Volume");

        for (int i = 0; i < stockData.size(); i++) {
            volumeSeries.add(i, stockData.get(i)[5]);
        }

        dataset.addSeries(volumeSeries);
        return dataset;
    }
}


