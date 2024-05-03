package com.wangguangwu.datasnowball.service.realtime.impl;

import com.wangguangwu.datasnowball.component.HttpFetcherComponent;
import com.wangguangwu.datasnowball.constant.KlineUrlConstant;
import com.wangguangwu.datasnowball.constant.RealTimeUrlConstant;
import com.wangguangwu.datasnowball.service.realtime.RealTimeFetchService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class RealTimeFetchServiceImpl implements RealTimeFetchService {

    private static final Integer DEFAULT_DAYS = 100;

    @Resource
    private HttpFetcherComponent fetcherComponent;

    @Override
    public String quoteC(String symbol) {
        return fetcherComponent.fetchWithoutToken(RealTimeUrlConstant.REALTIME_QUOTE + symbol);
    }

    @Override
    public String quoteDetail(String symbol) {
        return fetcherComponent.fetch(RealTimeUrlConstant.REALTIME_QUOTE_DETAIL + symbol);
    }

    @Override
    public String panKou(String symbol) {
        return fetcherComponent.fetch(RealTimeUrlConstant.REALTIME_PAN_KOU + symbol);
    }

    @Override
    public String klineFetch(String symbol, int days) {
        long currentTimeMillis = System.currentTimeMillis();
        days = days == 0 ? DEFAULT_DAYS : days;
        String url = String.format(KlineUrlConstant.KLINE, symbol, currentTimeMillis, days);

        return fetcherComponent.fetch(url);
    }
}
