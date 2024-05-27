package com.wangguangwu.datatushare.service.stock.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.wangguangwu.datatushare.entity.StockBasicInfoDO;
import com.wangguangwu.datatushare.service.basic.BaseSaveOrUpdateService;
import com.wangguangwu.datatushare.service.basic.StockBasicInfoService;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@ConditionalOnBean(StockBasicInfoService.class)
public class StockBasicInfoSaveOrUpdateServiceImpl implements BaseSaveOrUpdateService<StockBasicInfoDO> {

    @Resource
    private StockBasicInfoService stockBasicInfoService;

    @Override
    public StockBasicInfoDO getOne(LambdaQueryWrapper<StockBasicInfoDO> queryWrapper) {
        return stockBasicInfoService.list(queryWrapper).get(0);
    }

    @Override
    public Boolean save(StockBasicInfoDO entity) {
        return stockBasicInfoService.save(entity);
    }

    @Override
    public Boolean update(StockBasicInfoDO entity, LambdaUpdateWrapper<StockBasicInfoDO> updateWrapper) {
        return stockBasicInfoService.update(entity, updateWrapper);
    }

    @Override
    public LambdaQueryWrapper<StockBasicInfoDO> createQueryWrapper(StockBasicInfoDO entity) {
        LambdaQueryWrapper<StockBasicInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StockBasicInfoDO::getTsCode, entity.getTsCode())
                .eq(StockBasicInfoDO::getIsDeleted, false);
        return queryWrapper;
    }

    @Override
    public LambdaUpdateWrapper<StockBasicInfoDO> createUpdateWrapper(StockBasicInfoDO entity) {
        LambdaUpdateWrapper<StockBasicInfoDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(StockBasicInfoDO::getTsCode, entity.getTsCode())
                // TODO: 如何处理乐观锁 version 的问题
                .eq(StockBasicInfoDO::getIsDeleted, false);
        return updateWrapper;
    }
}
