package com.wangguangwu.datatushare.service.quotes.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.wangguangwu.datatushare.constant.QueryFieldsConstant;
import com.wangguangwu.datatushare.constant.UrlConstant;
import com.wangguangwu.datatushare.dto.ApiResponse;
import com.wangguangwu.datatushare.dto.MarketData;
import com.wangguangwu.datatushare.entity.DailyMarketDataDO;
import com.wangguangwu.datatushare.service.basic.DailyMarketDataService;
import com.wangguangwu.datatushare.service.quotes.MarketDataService;
import com.wangguangwu.datatushare.util.ConvertUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class MarketDataServiceImpl implements MarketDataService {

    private static final String TOKEN = "7c0b962c215058d6fcf4085f586a0e789827e9b131326f0e4deef9a2";

    @Resource
    private DailyMarketDataService dailyMarketDataService;

    @Override
    public void dailyMarketService() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("发起请求");
        String responseBody = sendStockBasicRequest();
        stopWatch.stop();

        if (responseBody == null) {
            return;
        }

        stopWatch.start("解析数据");
        List<MarketData> marketDataList = parseMarketData(responseBody);
        stopWatch.stop();

        if (CollUtil.isEmpty(marketDataList)) {
            return;
        }

        stopWatch.start("保存数据");
        List<DailyMarketDataDO> stockBasicInfoDOList = marketDataList.stream().map(marketData -> {
            DailyMarketDataDO dailyMarketDataDO = ConvertUtil.convertSourceToTarget(marketData, DailyMarketDataDO.class);
            dailyMarketDataDO.setOpen(new BigDecimal(marketData.getOpen()));
            dailyMarketDataDO.setHigh(new BigDecimal(marketData.getHigh()));
            dailyMarketDataDO.setLow(new BigDecimal(marketData.getLow()));
            dailyMarketDataDO.setClose(new BigDecimal(marketData.getClose()));
            dailyMarketDataDO.setPreClose(new BigDecimal(marketData.getPreClose()));
            dailyMarketDataDO.setTsChange(new BigDecimal(marketData.getChange()));
            dailyMarketDataDO.setPctChg(new BigDecimal(marketData.getPctChg()));
            dailyMarketDataDO.setVol(new BigDecimal(marketData.getVol()));
            dailyMarketDataDO.setAmount(new BigDecimal(marketData.getAmount()));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            dailyMarketDataDO.setTradeDate(LocalDate.parse(marketData.getTradeDate(), formatter));
            return dailyMarketDataDO;
        }).toList();
        dailyMarketDataService.saveOrUpdateBatch(stockBasicInfoDOList);
        stopWatch.stop();
    }

    private JSONObject createRequestBody() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.set("api_name", "daily");
        jsonBody.set("token", TOKEN);
        JSONObject params = new JSONObject();
        params.set("ts_code", "000001.SZ");
        params.set("start_date", "20180701");
        params.set("end_date", "20180718");
        jsonBody.set("params", params);
        jsonBody.set("fields", QueryFieldsConstant.MARKET_DATA_FIELDS);
        return jsonBody;
    }

    private String sendStockBasicRequest() {
        JSONObject jsonBody = createRequestBody();
        HttpResponse httpResponse = HttpRequest.post(UrlConstant.PRO_URL)
                .body(jsonBody.toStringPretty())
                .execute();

        if (httpResponse.isOk()) {
            return httpResponse.body();
        } else {
            log.error("Failed to fetch stock data: {}, error message: {}", httpResponse.getStatus(), JSON.toJSON(httpResponse));
            return null;
        }
    }

    private List<MarketData> parseMarketData(String body) {
        ApiResponse response = JSON.parseObject(body, ApiResponse.class);
        List<List<String>> items = response.getData().getItems();
        List<MarketData> marketData = new ArrayList<>();
        for (List<String> item : items) {
            MarketData stockInfo = new MarketData(
                    item.get(0), item.get(1), item.get(2), item.get(3), item.get(4), item.get(5),
                    item.get(6), item.get(7), item.get(8), item.get(9), item.get(10)
            );
            marketData.add(stockInfo);
        }
        return marketData;
    }
}
