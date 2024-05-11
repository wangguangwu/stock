package com.wangguangwu.datasnowball.service.f10.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangguangwu.datasnowball.entity.MainIndicatorItemDO;
import com.wangguangwu.datasnowball.entity.TopHoldersItemDO;
import com.wangguangwu.datasnowball.entity.TopHoldersQuitDO;
import com.wangguangwu.datasnowball.entity.TopHoldersSummaryDO;
import com.wangguangwu.datasnowball.response.ApiResponse;
import com.wangguangwu.datasnowball.response.f10.mainindicator.MainIndicatorItem;
import com.wangguangwu.datasnowball.response.f10.mainindicator.MainIndicatorResponseData;
import com.wangguangwu.datasnowball.response.f10.skholder.SkHolderResponseData;
import com.wangguangwu.datasnowball.response.f10.topholders.TimeData;
import com.wangguangwu.datasnowball.response.f10.topholders.TopHoldersResponseData;
import com.wangguangwu.datasnowball.service.f10.F10SaveService;
import com.wangguangwu.datasnowball.service.f10.MainIndicatorService;
import com.wangguangwu.datasnowball.service.f10.TopHolderService;
import com.wangguangwu.datasnowball.util.ApiResponseUtil;
import com.wangguangwu.datasnowball.util.ConvertUtil;
import com.wangguangwu.datasnowball.util.DateUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class F10SaveServiceImpl implements F10SaveService {

    @Resource
    private TopHolderService topHolderService;
    @Resource
    private MainIndicatorService mainIndicatorService;

    @Override
    public void skHolderSave(String json) {
        if (CharSequenceUtil.isBlank(json)) {
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            ApiResponse<SkHolderResponseData> response = mapper.readValue(json, new TypeReference<>() {
            });
            Integer errorCode = response.getErrorCode();
            if (errorCode != 0) {
                log.error("响应[{}]响应码不为 200: {}", json, errorCode);
            }
        } catch (JsonProcessingException e) {
            log.error("响应[{}]解析失败: {}", json, e.getMessage(), e);
        }
    }

    @Override
    public boolean topHoldersSave(String symbol, String json) {
        if (CharSequenceUtil.isBlank(json)) {
            return false;
        }

        return ApiResponseUtil.transfer(json, TopHoldersResponseData.class)
                .map(data -> processTimeData(data, symbol))
                .orElse(false);
    }

    @Override
    public boolean mainIndicatorSave(String symbol, String json) {
        if (CharSequenceUtil.isBlank(json)) {
            return false;
        }

        return ApiResponseUtil.transfer(json, MainIndicatorResponseData.class)
                .map(data -> processMainIndicatorItem(symbol, data))
                .orElse(false);
    }

    //=====================================私有方法==========================================

    private boolean processMainIndicatorItem(String symbol, MainIndicatorResponseData data) {
        Set<String> existsReports = mainIndicatorService.listExistsReports(symbol);

        List<MainIndicatorItemDO> mainIndicatorItemDOList = data.getItems().stream()
                .filter(item -> !existsReports.contains(item.getReportDate()))
                .map(item -> {
                    MainIndicatorItemDO mainIndicatorItemDO = ConvertUtil.convertSourceToTarget(item, MainIndicatorItemDO.class);
                    mainIndicatorItemDO.setSymbol(symbol);
                    return mainIndicatorItemDO;
                })
                .toList();

        return mainIndicatorService.saveMainIndicators(mainIndicatorItemDOList);
    }

    private boolean processTimeData(TopHoldersResponseData data, String symbol) {
        return data.getTimes().stream().max(Comparator.comparingLong(TimeData::getValue)).map(maxTimeData -> {
            String currentReportName = maxTimeData.getName();
            if (!topHolderService.existReport(symbol, currentReportName)) {
                return saveResponseData(data, symbol, currentReportName, maxTimeData.getValue());
            }
            return false;
        }).orElse(false);
    }

    private boolean saveResponseData(TopHoldersResponseData data, String symbol, String currentReportName, Long reportDate) {
        // 当前报告汇总
        TopHoldersSummaryDO topHoldersSummaryDO = ConvertUtil.convertSourceToTarget(data.getTotal(), TopHoldersSummaryDO.class);
        topHoldersSummaryDO.setSymbol(symbol);
        topHoldersSummaryDO.setReportName(currentReportName);
        topHoldersSummaryDO.setReportDate(DateUtil.convertLongToLocalDate(reportDate));
        // 当前十大股东
        List<TopHoldersItemDO> topHoldersItemDOList = data.getItems().stream().map(item -> ConvertUtil.convertSourceToTarget(item, TopHoldersItemDO.class)).toList();
        // 当前报告下退出
        List<TopHoldersQuitDO> topHoldersQuitDOList = data.getQuit().stream().map(quit -> ConvertUtil.convertSourceToTarget(quit, TopHoldersQuitDO.class)).toList();
        return topHolderService.saveTopHolderMessages(topHoldersSummaryDO, topHoldersItemDOList, topHoldersQuitDOList);
    }
}
