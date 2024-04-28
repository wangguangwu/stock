package com.wangguangwu.datatushare.component;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.wangguangwu.datatushare.constant.UrlConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    protected JSONObject params;

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
     * @param json 响应报文
     * @return T 泛型
     */
    protected abstract List<T> convertItemToDataObject(String json);

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public void setParams(JSONObject params) {
        this.params = params;
    }

    public final void fetchAndSaveData(String operation) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("发起请求");
        String responseBody = sendRequest();
        stopWatch.stop();

        if (responseBody == null) {
            return;
        }

        stopWatch.start("解析数据");
        List<T> dataList = convertItemToDataObject(responseBody);
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

    protected LocalDate parseDate(String dateStr) {
        if (CharSequenceUtil.isNotBlank(dateStr)) {
            try {
                return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
            } catch (DateTimeParseException e) {
                // 可以记录错误或进行其他错误处理
                log.error("Invalid date format: {}", dateStr);
                return null;
            }
        }
        return null;
    }

    protected BigDecimal parseBigDecimal(String value) {
        if (CharSequenceUtil.isNotBlank(value)) {
            try {
                return new BigDecimal(value);
            } catch (NumberFormatException e) {
                // 可以记录日志或进行其他错误处理
                log.error("Invalid input for BigDecimal conversion: {}", value);
                return null;
            }
        }
        return null;
    }
}
