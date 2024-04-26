package com.wangguangwu.datatushare.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author wangguangwu
 */
public final class ConvertUtil {

    private ConvertUtil() {
    }

    public static <S, T> T convertSourceToTarget(S source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        T targetInstance;
        try {
            targetInstance = targetClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new IllegalArgumentException("ConvertUtil.convertSToT 失败", e);
        }
        BeanUtils.copyProperties(source, targetInstance);
        return targetInstance;
    }
}
