package com.wangguangwu.datasnowball.service.f10;

/**
 * @author wangguangwu
 */
public interface F10SaveService {

    /**
     * 获取公司股东信息。
     *
     * @param json json 报文
     */
    void skHolderSave(String json);

    /**
     * 获取十大股东信息。
     *
     * @param symbol 股票代码
     * @param json   json 报文
     */
    void topHoldersSave(String symbol, String json);

}
