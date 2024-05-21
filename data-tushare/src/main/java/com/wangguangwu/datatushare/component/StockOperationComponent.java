package com.wangguangwu.datatushare.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datatushare.entity.StockBasicInfoDO;
import com.wangguangwu.datatushare.service.basic.StockBasicInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Component
@Slf4j
public class StockOperationComponent {

    @Resource
    private StockBasicInfoService stockBasicInfoService;

    public Set<String> getTsCodeList() {
        LambdaQueryWrapper<StockBasicInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StockBasicInfoDO::getIsDeleted, false)
                .select(StockBasicInfoDO::getTsCode);
        return stockBasicInfoService.list(queryWrapper)
                .stream()
                .map(StockBasicInfoDO::getTsCode)
                .collect(Collectors.toSet());
    }
}
