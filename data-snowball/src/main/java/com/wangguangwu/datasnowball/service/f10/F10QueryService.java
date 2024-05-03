package com.wangguangwu.datasnowball.service.f10;

/**
 * @author wangguangwu
 */
public interface F10QueryService {

    /**
     * 查询是否存在十大股东数据
     *
     * @param symbol 股票代码
     * @return 是否存在
     */
    boolean topHoldersQuery(String symbol);

}
