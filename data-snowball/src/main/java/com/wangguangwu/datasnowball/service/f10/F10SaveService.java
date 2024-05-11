package com.wangguangwu.datasnowball.service.f10;

/**
 * @author wangguangwu
 */
public interface F10SaveService {

    /**
     * 保存公司股东信息。
     *
     * @param json json 报文
     */
    void skHolderSave(String json);

    /**
     * 保存十大股东信息。
     *
     * @param symbol 股票代码
     * @param json   json 报文
     * @return 是否更新成功
     */
    boolean topHoldersSave(String symbol, String json);

    /**
     * 保存财务指标信息。
     *
     * @param symbol 股票代码
     * @param json   json 报文
     * @return 是否更新成功
     */
    boolean mainIndicatorSave(String symbol, String json);

}
