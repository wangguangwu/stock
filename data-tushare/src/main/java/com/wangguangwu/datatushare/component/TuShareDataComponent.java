package com.wangguangwu.datatushare.component;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.wangguangwu.datatushare.constant.UrlConstant;
import com.wangguangwu.datatushare.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import static com.wangguangwu.datatushare.constant.TokenConstant.TOKEN;

/**
 * 访问 tushare 数据的通用模版方法
 *
 * @author wangguangwu
 */
@Component
@Slf4j
public abstract class TuShareDataComponent<T> {

    /**
     * 获取请求参数
     *
     * @return 请求参数
     */
    protected abstract JSONObject getParams();

    /**
     * 构建请求体
     *
     * @return JSONObject
     */
    protected abstract JSONObject createBasicRequestBody();

    /**
     * 保存数据
     *
     * @param list 数据
     */
    protected abstract void saveOrUpdateBatch(List<T> list);

    /**
     * 解析 tushare 响应中的 item
     *
     * @param item 实际响应数据
     * @return T 泛型
     */
    protected abstract T convertItemToDataObject(List<String> item);

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public final void fetchAndSaveData(String operation) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("发起请求");
        String responseBody = sendRequest();
        stopWatch.stop();

        if (responseBody == null) {
            return;
        }

        stopWatch.start("解析数据");
        List<T> dataList = parseData(responseBody);
        stopWatch.stop();

        if (CollUtil.isEmpty(dataList)) {
            return;
        }

        stopWatch.start("保存数据");
        saveOrUpdateBatch(dataList);
        stopWatch.stop();
        log.info("执行[{}]耗时: {}", operation, stopWatch.prettyPrint());
    }

    private String sendRequest() {
        JSONObject params = getParams();
        JSONObject jsonBody = createBasicRequestBody();
        jsonBody.set("params", params);
        jsonBody.set("token", TOKEN);
        HttpResponse httpResponse = HttpRequest.post(UrlConstant.PRO_URL).body(jsonBody.toStringPretty()).execute();

        if (httpResponse.isOk()) {
            return httpResponse.body();
        } else {
            log.error("Failed to fetch data: {}, error message: {}", httpResponse.getStatus(), JSON.toJSON(httpResponse));
            return null;
        }
    }

    private List<T> parseData(String body) {
        ApiResponse response = JSON.parseObject(body, ApiResponse.class);
        List<List<String>> items = response.getData().getItems();
        if (CollUtil.isEmpty(items)) {
            return Collections.emptyList();
        }
        return items.stream().map(this::convertItemToDataObject).toList();
    }

    protected LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, formatter);
    }

    protected BigDecimal parseBigDecimal(String value) {
        return new BigDecimal(value);
    }
}
