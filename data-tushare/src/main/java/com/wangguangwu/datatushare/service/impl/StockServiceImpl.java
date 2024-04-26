package com.wangguangwu.datatushare.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.wangguangwu.datatushare.dto.ApiResponse;
import com.wangguangwu.datatushare.dto.StockInfo;
import com.wangguangwu.datatushare.entity.StockBasicInfoDO;
import com.wangguangwu.datatushare.service.StockService;
import com.wangguangwu.datatushare.service.StockTransactionService;
import com.wangguangwu.datatushare.service.basic.StockBasicInfoService;
import com.wangguangwu.datatushare.util.ConvertUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService {

    private static final String URL = "http://api.tushare.pro";
    private static final String TOKEN = "7c0b962c215058d6fcf4085f586a0e789827e9b131326f0e4deef9a2";
    private static final List<String> FIELDS = Arrays.asList("ts_code", "name", "area", "market", "industry", "list_date");

    @Resource
    private StockBasicInfoService stockBasicInfoService;

    @Override
    public void stockBasicItem() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("发起请求");
        String responseBody = sendStockBasicRequest();
        stopWatch.stop();

        if (responseBody == null) {
            return;
        }

        stopWatch.start("解析数据");
        List<StockInfo> stockInfos = parseStockInfo(responseBody);
        stopWatch.stop();

        if (CollUtil.isEmpty(stockInfos)) {
            return;
        }

        stopWatch.start("保存数据");
        List<StockBasicInfoDO> stockBasicInfoDOList = stockInfos.stream().map(stockInfo -> {
            StockBasicInfoDO stockBasicInfoDO = ConvertUtil.convertSourceToTarget(stockInfo, StockBasicInfoDO.class);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            stockBasicInfoDO.setListDate(LocalDate.parse(stockInfo.getListDate(), formatter));
            return stockBasicInfoDO;
        }).toList();
        stockBasicInfoService.saveOrUpdateBatch(stockBasicInfoDOList);
        stopWatch.stop();
    }


    private String sendStockBasicRequest() {
        JSONObject jsonBody = createRequestBody();
        HttpResponse httpResponse = HttpRequest.post(URL)
                .body(jsonBody.toStringPretty())
                .execute();

        if (httpResponse.isOk()) {
            return httpResponse.body();
        } else {
            log.error("Failed to fetch stock data: {}, error message: {}", httpResponse.getStatus(), JSON.toJSON(httpResponse));
            return null;
        }
    }

    private JSONObject createRequestBody() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.set("api_name", "stock_basic");
        jsonBody.set("token", TOKEN);
        JSONObject params = new JSONObject();
        params.set("list_status", "L");
        jsonBody.set("params", params);
        jsonBody.set("fields", FIELDS);
        return jsonBody;
    }

    private List<StockInfo> parseStockInfo(String body) {
        ApiResponse response = JSON.parseObject(body, ApiResponse.class);
        List<List<String>> items = response.getData().getItems();
        List<StockInfo> stockInfos = new ArrayList<>();
        for (List<String> item : items) {
            StockInfo stockInfo = new StockInfo(
                    item.get(0), item.get(1), item.get(2), item.get(3), item.get(4), item.get(5)
            );
            stockInfos.add(stockInfo);
        }
        return stockInfos;
    }
}
