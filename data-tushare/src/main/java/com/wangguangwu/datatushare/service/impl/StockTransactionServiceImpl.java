package com.wangguangwu.datatushare.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.wangguangwu.datatushare.entity.StockBasicInfoDO;
import com.wangguangwu.datatushare.service.StockTransactionService;
import com.wangguangwu.datatushare.service.basic.StockBasicInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class StockTransactionServiceImpl implements StockTransactionService {

    @Resource
    private StockBasicInfoService stockBasicInfoService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveStockBasicItem(List<StockBasicInfoDO> stockBasicInfoDOList) {

    }

    public static void main(String[] args) {
        Object o = new Object();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.getBeanFactory().registerSingleton("xxx", o);
    }
}
