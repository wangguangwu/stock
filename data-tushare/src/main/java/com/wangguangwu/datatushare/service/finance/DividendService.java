package com.wangguangwu.datatushare.service.finance;

/**
 * 查询分红送股数据
 *
 * @author wangguangwu
 */
public interface DividendService {

    /**
     * 获取并且保存分红送股数据
     *
     * @param symbol 股票代码
     * @return 保存成功/失败
     */
    boolean dividend(String symbol);

}
