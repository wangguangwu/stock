package com.wangguangwu.datatushare.service.basic;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;

/**
 * 根据自定义字段判断是保存还是更新。
 *
 * @author wangguangwu
 */
public interface BaseSaveOrUpdateService<T> {

    /**
     * 查询是否存在符合条件的数据
     *
     * @param queryWrapper queryWrapper
     * @return boolean
     */
    T getOne(LambdaQueryWrapper<T> queryWrapper);

    /**
     * 保存数据
     *
     * @param entity entity
     * @return boolean
     */
    Boolean save(T entity);

    /**
     * 更新数据
     *
     * @param entity        entity
     * @param updateWrapper updateWrapper
     * @return boolean
     */
    Boolean update(T entity, LambdaUpdateWrapper<T> updateWrapper);

    /**
     * 创建 lambdaQueryWrapper
     *
     * @param entity entity
     * @return lambdaQueryWrapper
     */
    LambdaQueryWrapper<T> createQueryWrapper(T entity);

    /**
     * 创建 lambdaUpdateWrapper
     *
     * @param entity entity
     * @return lambdaQueryWrapper
     */
    LambdaUpdateWrapper<T> createUpdateWrapper(T entity);

}
