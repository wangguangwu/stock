package com.wangguangwu.datatushare.component.quotes;

import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.component.TuShareDataComponent;
import com.wangguangwu.datatushare.constant.QueryFieldsConstant;
import com.wangguangwu.datatushare.dto.BakDaily;
import com.wangguangwu.datatushare.entity.BakDailyDO;
import com.wangguangwu.datatushare.service.basic.BakDailyService;
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
public class BakDailyComponent extends TuShareDataComponent<BakDailyDO> {

    @Resource
    private BakDailyService bakDailyService;

    @Override
    protected JSONObject createBasicRequestBody() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.set("api_name", "bak_daily");

        jsonBody.set("fields", QueryFieldsConstant.BAK_DAILY_FIELDS);
        return jsonBody;
    }

    @Override
    protected void saveOrUpdateBatch(List<BakDailyDO> list) {
        bakDailyService.saveOrUpdateBatch(list);
    }

    @Override
    protected List<BakDailyDO> convertItemToDataObject(String json) {
        List<BakDaily> bakDailyList = ConvertUtil.convertJsonToObjects(json, BakDaily.class);
        return bakDailyList.stream().map(bakDaily -> {
            BakDailyDO bakDailyDO = ConvertUtil.convertWithTypeTransfer(bakDaily, BakDailyDO.class);
            bakDailyDO.setTsChange(parseBigDecimal(bakDaily.getChange()));
            return bakDailyDO;
        }).toList();
    }
}
