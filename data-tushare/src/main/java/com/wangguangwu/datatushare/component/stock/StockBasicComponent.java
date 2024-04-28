package com.wangguangwu.datatushare.component.stock;

import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.component.TuShareDataComponent;
import com.wangguangwu.datatushare.constant.QueryFieldsConstant;
import com.wangguangwu.datatushare.dto.StockInfo;
import com.wangguangwu.datatushare.entity.StockBasicInfoDO;
import com.wangguangwu.datatushare.service.basic.StockBasicInfoService;
import com.wangguangwu.datatushare.util.ConvertUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author wangguangwu
 */
@Component
@Slf4j
public class StockBasicComponent extends TuShareDataComponent<StockBasicInfoDO> {

    @Resource
    private StockBasicInfoService stockBasicInfoService;

    @Override
    protected JSONObject createBasicRequestBody() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.set("api_name", "stock_basic");
        jsonBody.set("fields", QueryFieldsConstant.STOCK_BASIC_FIELDS);
        return jsonBody;
    }

    @Override
    protected void saveOrUpdateBatch(List<StockBasicInfoDO> list) {
        stockBasicInfoService.saveOrUpdateBatch(list);
    }

    @Override
    protected List<StockBasicInfoDO> convertItemToDataObject(String json) {
        List<StockInfo> stockInfoList = ConvertUtil.convertJsonToObjects(json, StockInfo.class);
        return stockInfoList.stream().map(this::getStockBasicInfoDO).toList();
    }

    private StockBasicInfoDO getStockBasicInfoDO(StockInfo stockInfo) {
        StockBasicInfoDO stockBasicInfoDO = ConvertUtil.convertSourceToTarget(stockInfo, StockBasicInfoDO.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        stockBasicInfoDO.setListDate(LocalDate.parse(stockInfo.getListDate(), formatter));
        return stockBasicInfoDO;
    }
}
