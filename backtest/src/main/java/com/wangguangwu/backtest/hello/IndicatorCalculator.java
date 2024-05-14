package com.wangguangwu.backtest.hello;

import java.util.ArrayList;
import java.util.List;


/**
 * 计算 MACD 和 KDJ 指标
 *
 * @author wangguangwu
 */
public class IndicatorCalculator {

    public static List<Double[]> calculateMACD(List<Double[]> stockData) {
        List<Double> closePrices = new ArrayList<>();
        for (Double[] data : stockData) {
            closePrices.add(data[4]);
        }

        int shortPeriod = 12;
        int longPeriod = 26;
        int signalPeriod = 9;

        List<Double> shortEma = calculateEMA(closePrices, shortPeriod);
        List<Double> longEma = calculateEMA(closePrices, longPeriod);

        List<Double> macdLine = new ArrayList<>();
        for (int i = 0; i < longEma.size(); i++) {
            macdLine.add(shortEma.get(i + (longPeriod - shortPeriod)) - longEma.get(i));
        }

        List<Double> signalLine = calculateEMA(macdLine, signalPeriod);
        List<Double> histogram = new ArrayList<>();
        for (int i = 0; i < signalLine.size(); i++) {
            histogram.add(macdLine.get(i + (signalPeriod - 1)) - signalLine.get(i));
        }

        List<Double[]> macdData = new ArrayList<>();
        for (int i = 0; i < histogram.size(); i++) {
            macdData.add(new Double[]{
                macdLine.get(i + (signalPeriod - 1)),
                signalLine.get(i),
                histogram.get(i)
            });
        }

        return macdData;
    }

    private static List<Double> calculateEMA(List<Double> prices, int period) {
        List<Double> ema = new ArrayList<>();
        double multiplier = 2.0 / (period + 1);

        double sum = 0.0;
        for (int i = 0; i < period; i++) {
            sum += prices.get(i);
        }
        ema.add(sum / period);

        for (int i = period; i < prices.size(); i++) {
            double emaValue = ((prices.get(i) - ema.get(ema.size() - 1)) * multiplier) + ema.get(ema.size() - 1);
            ema.add(emaValue);
        }

        return ema;
    }

    public static List<Double[]> calculateKDJ(List<Double[]> stockData) {
        List<Double> closePrices = new ArrayList<>();
        List<Double> lowPrices = new ArrayList<>();
        List<Double> highPrices = new ArrayList<>();
        for (Double[] data : stockData) {
            closePrices.add(data[4]);
            lowPrices.add(data[3]);
            highPrices.add(data[2]);
        }

        List<Double> k = new ArrayList<>();
        List<Double> d = new ArrayList<>();
        List<Double> j = new ArrayList<>();

        for (int i = 0; i < closePrices.size(); i++) {
            double low = lowPrices.subList(Math.max(0, i - 8), i + 1).stream().min(Double::compare).orElse(closePrices.get(i));
            double high = highPrices.subList(Math.max(0, i - 8), i + 1).stream().max(Double::compare).orElse(closePrices.get(i));
            double rsv = 100 * (closePrices.get(i) - low) / (high - low);

            double kValue = i == 0 ? rsv : (2 * k.get(i - 1) + rsv) / 3;
            double dValue = i == 0 ? rsv : (2 * d.get(i - 1) + kValue) / 3;
            double jValue = 3 * kValue - 2 * dValue;

            k.add(kValue);
            d.add(dValue);
            j.add(jValue);
        }

        List<Double[]> kdjData = new ArrayList<>();
        for (int i = 0; i < k.size(); i++) {
            kdjData.add(new Double[]{k.get(i), d.get(i), j.get(i)});
        }

        return kdjData;
    }
}

