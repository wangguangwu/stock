package com.wangguangwu.datasnowball.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datasnowball.entity.StockBasicInfoDO;
import com.wangguangwu.datasnowball.service.basic.StockBasicInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangguangwu
 */
@Component
@Slf4j
public class StockBasicComponent {

    @Resource
    private StockBasicInfoService stockBasicInfoService;

    public List<String> getSymbolList() {
        LambdaQueryWrapper<StockBasicInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StockBasicInfoDO::getIsDeleted, false);
        return stockBasicInfoService.list(queryWrapper).stream().map(StockBasicInfoDO::getSymbol).toList();
    }
}
