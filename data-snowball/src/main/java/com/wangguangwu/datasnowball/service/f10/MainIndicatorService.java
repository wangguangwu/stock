package com.wangguangwu.datasnowball.service.f10;

import com.wangguangwu.datasnowball.entity.MainIndicatorItemDO;

import java.util.List;
import java.util.Set;

/**
 * @author wangguangwu
 */
public interface MainIndicatorService {

    /**
     * 获取股票下已经存在的报告
     *
     * @param symbol 股票代码
     * @return 股票下已经存在的报告
     */
    Set<String> listExistsReports(String symbol);

    /**
     * 保存股票对应的报告数据
     *
     * @param mainIndicatorItemDOList 股票对应的报告数据
     * @return 保存是否成功
     */
    boolean saveMainIndicators(List<MainIndicatorItemDO> mainIndicatorItemDOList);

}
