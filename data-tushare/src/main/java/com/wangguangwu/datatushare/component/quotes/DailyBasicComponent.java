package com.wangguangwu.datatushare.component.quotes;

import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.component.TuShareDataComponent;
import com.wangguangwu.datatushare.constant.QueryFieldsConstant;
import com.wangguangwu.datatushare.dto.DailyIndicators;
import com.wangguangwu.datatushare.entity.DailyIndicatorsDO;
import com.wangguangwu.datatushare.service.basic.DailyIndicatorsService;
import com.wangguangwu.datatushare.util.ConvertUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangguangwu
 */
@Component
@Slf4j
public class DailyBasicComponent extends TuShareDataComponent<DailyIndicatorsDO> {

    @Resource
    private DailyIndicatorsService dailyIndicatorsService;

    @Override
    protected JSONObject createBasicRequestBody() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.set("api_name", "daily_basic");

        jsonBody.set("fields", QueryFieldsConstant.DAILY_INDICATORS_FIELDS);
        return jsonBody;
    }

    @Override
    protected void saveOrUpdateBatch(List<DailyIndicatorsDO> list) {
        dailyIndicatorsService.saveOrUpdateBatch(list);
    }

    @Override
    protected DailyIndicatorsDO convertItemToDataObject(List<String> item) {
        DailyIndicators dailyIndicators = new DailyIndicators(
                item.get(0), item.get(1), item.get(2), item.get(3), item.get(4), item.get(5),
                item.get(6), item.get(7), item.get(8), item.get(9), item.get(10), item.get(11),
                item.get(12), item.get(13), item.get(14), item.get(15), item.get(16), item.get(17)
        );

        DailyIndicatorsDO dailyIndicatorsDO = ConvertUtil.convertSourceToTarget(dailyIndicators, DailyIndicatorsDO.class);
        dailyIndicatorsDO.setTradeDate(parseDate(dailyIndicators.getTradeDate()));
        dailyIndicatorsDO.setClose(parseBigDecimal(dailyIndicators.getClose()));
        dailyIndicatorsDO.setTurnoverRate(parseBigDecimal(dailyIndicators.getTurnoverRate()));
        dailyIndicatorsDO.setTurnoverRateF(parseBigDecimal(dailyIndicators.getTurnoverRateF()));
        dailyIndicatorsDO.setVolumeRatio(parseBigDecimal(dailyIndicators.getVolumeRatio()));
        dailyIndicatorsDO.setPe(parseBigDecimal(dailyIndicators.getPe()));
        dailyIndicatorsDO.setPeTtm(parseBigDecimal(dailyIndicators.getPeTtm()));
        dailyIndicatorsDO.setPb(parseBigDecimal(dailyIndicators.getPb()));
        dailyIndicatorsDO.setPs(parseBigDecimal(dailyIndicators.getPs()));
        dailyIndicatorsDO.setPsTtm(parseBigDecimal(dailyIndicators.getPsTtm()));
        dailyIndicatorsDO.setDvRatio(parseBigDecimal(dailyIndicators.getDvRatio()));
        dailyIndicatorsDO.setDvTtm(parseBigDecimal(dailyIndicators.getDvTtm()));
        dailyIndicatorsDO.setFreeShare(parseBigDecimal(dailyIndicators.getFreeShare()));
        dailyIndicatorsDO.setTotalShare(parseBigDecimal(dailyIndicators.getTotalShare()));
        dailyIndicatorsDO.setFloatShare(parseBigDecimal(dailyIndicators.getFloatShare()));
        dailyIndicatorsDO.setTotalMv(parseBigDecimal(dailyIndicators.getTotalMv()));
        dailyIndicatorsDO.setCircMv(parseBigDecimal(dailyIndicators.getCircMv()));

        return dailyIndicatorsDO;
    }
}
