package com.wangguangwu.datatushare.service.basic.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.wangguangwu.datatushare.service.basic.BaseSaveOrUpdateService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * 通用保存和更新服务.
 *
 * @author wangguangwu
 */
@Service
public class GenericSaveOrUpdateService {

    @Resource
    private TransactionTemplate transactionTemplate;

    @Transactional(rollbackFor = Exception.class)
    public <T, S extends BaseSaveOrUpdateService<T>> Boolean saveOrUpdate(T entity, S service) {
        return saveOrUpdateInternal(entity, service);
    }

    public <T, S extends BaseSaveOrUpdateService<T>> Boolean saveOrUpdate(List<T> entities, S service) {
        return transactionTemplate.execute(status -> {
            try {
                for (T entity : entities) {
                    Boolean result = saveOrUpdateInternal(entity, service);
                    if (Boolean.FALSE.equals(result)) {
                        status.setRollbackOnly();
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                status.setRollbackOnly();
                throw e;
            }
        });
    }

    private <T, S extends BaseSaveOrUpdateService<T>> Boolean saveOrUpdateInternal(T entity, S service) {
        LambdaQueryWrapper<T> wrapper = service.createQueryWrapper(entity);
        T data = service.getOne(wrapper);
        if (data != null) {
            LambdaUpdateWrapper<T> updateWrapper = service.createUpdateWrapper(entity);
            return service.update(entity, updateWrapper);
        } else {
            return service.save(entity);
        }
    }
}
