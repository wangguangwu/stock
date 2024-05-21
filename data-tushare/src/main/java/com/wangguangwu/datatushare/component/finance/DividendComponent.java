package com.wangguangwu.datatushare.component.finance;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.component.TuShareDataComponent;
import com.wangguangwu.datatushare.constant.QueryFieldsConstant;
import com.wangguangwu.datatushare.dto.DividendInfo;
import com.wangguangwu.datatushare.entity.DividendItemDO;
import com.wangguangwu.datatushare.service.basic.DividendItemService;
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
public class DividendComponent extends TuShareDataComponent<DividendItemDO> {

    @Resource
    private DividendItemService dividendItemService;

    @Override
    protected JSONObject createBasicRequestBody() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.set("api_name", "dividend");

        jsonBody.set("fields", QueryFieldsConstant.DIVIDEND_FIELDS);
        return jsonBody;
    }

    @Override
    protected boolean saveOrUpdateBatch(List<DividendItemDO> list) {
        if (CollUtil.isEmpty(list)) {
            return false;
        }
        return dividendItemService.saveBatch(list);
    }

    @Override
    protected List<DividendItemDO> convertItemToDataObject(String json) {
        List<DividendInfo> dividendInfoList = ConvertUtil.convertJsonToObjects(json, DividendInfo.class);
        return dividendInfoList.stream().map(dividendInfo -> {
            DividendItemDO dividendItemDO = ConvertUtil.convertWithTypeTransfer(dividendInfo, DividendItemDO.class);
            dividendItemDO.setDivListDate(dividendInfo.getDivListdate());
            return dividendItemDO;
        }).toList();
    }
}
