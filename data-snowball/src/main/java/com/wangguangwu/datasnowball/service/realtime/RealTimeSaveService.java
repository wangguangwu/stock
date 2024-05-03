package com.wangguangwu.datasnowball.service.realtime;

/**
 * @author wangguangwu
 */
public interface RealTimeSaveService {

    /**
     * 保存股票数据
     *
     * @param symbol 股票代码
     * @param json   响应数据
     * @return 是否保存成功
     */
    boolean klineSave(String symbol, String json);

}
