package com.wangguangwu.datasnowball.util;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangguangwu.datasnowball.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author wangguangwu
 */
@Slf4j
public final class ApiResponseUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private ApiResponseUtil() {
    }


    public static <T> Optional<T> transfer(String json, Class<T> clazz) {
        try {
            ApiResponse<T> response = MAPPER.readValue(json, MAPPER.getTypeFactory().constructParametricType(ApiResponse.class, clazz));

            Integer errorCode = response.getErrorCode();
            T data = response.getData();
            if (errorCode == 0 && data != null) {
                return Optional.of(data);
            }
            log.error("响应[{}]响应码不为 200 或者数据为空，errorCode: {}，data: {}", json, errorCode, JSON.toJSON(data));
        } catch (JsonProcessingException e) {
            log.error("响应[{}]解析失败: {}", json, e.getMessage(), e);
        }
        return Optional.empty();
    }
}
