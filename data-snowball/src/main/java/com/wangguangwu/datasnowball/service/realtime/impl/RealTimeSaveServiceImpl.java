package com.wangguangwu.datasnowball.service.realtime.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.wangguangwu.datasnowball.entity.StockQuotesInfoDO;
import com.wangguangwu.datasnowball.response.realtime.KlineItem;
import com.wangguangwu.datasnowball.service.realtime.RealTimeSaveService;
import com.wangguangwu.datasnowball.service.realtime.StockQuotesService;
import com.wangguangwu.datasnowball.util.ConvertUtil;
import com.wangguangwu.datasnowball.util.DateUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class RealTimeSaveServiceImpl implements RealTimeSaveService {

    @Resource
    private StockQuotesService stockQuotesService;

    @Override
    public boolean klineSave(String symbol, String json) {
        if (CharSequenceUtil.isBlank(json)) {
            return false;
        }
        List<KlineItem> klineItems = ConvertUtil.convertJsonToObjects(json, KlineItem.class);
        List<StockQuotesInfoDO> stockQuotesInfoDOList = klineItems.stream().map(
                item -> {
                    StockQuotesInfoDO stockQuotesInfoDO = ConvertUtil.convertWithTypeTransfer(item, StockQuotesInfoDO.class);
                    stockQuotesInfoDO.setSymbol(symbol);
                    stockQuotesInfoDO.setTradeDate(DateUtil.convertLongToLocalDate(Long.parseLong(item.getTimestamp())));
                    stockQuotesInfoDO.setTurnoverRate(new BigDecimal(item.getTurnoverrate()));
                    return stockQuotesInfoDO;
                }
        ).toList();
        return stockQuotesService.stockQuotesSave(symbol, stockQuotesInfoDOList);
    }
}
