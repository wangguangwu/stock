package com.wangguangwu.datatushare.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangguangwu
 */
@Slf4j
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

    public static <T> List<T> convertJsonToObjects(String json, Class<T> clazz) {
        List<T> objectList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode fieldsNode = rootNode.path("data").path("fields");
            JsonNode itemsNode = rootNode.path("data").path("items");

            List<String> fields = objectMapper.convertValue(fieldsNode, new TypeReference<>() {
            });

            if (itemsNode.isArray()) {
                for (JsonNode item : itemsNode) {
                    if (item.isArray()) {
                        T object = clazz.getDeclaredConstructor().newInstance();
                        for (int i = 0; i < item.size(); i++) {
                            String fieldName = fields.get(i);
                            String value = item.get(i).isNull() ? null : item.get(i).asText();
                            String camelCaseFieldName = toCamelCase(fieldName);
                            setFieldUsingReflection(object, camelCaseFieldName, value, clazz);
                        }
                        objectList.add(object);
                    }
                }
            }
            return objectList;
        } catch (JsonProcessingException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            log.error("调用 convertJsonToObjects 方法报错，报文: {}, 异常信息：{}", json, e.getMessage(), e);
        }
        return objectList;
    }

    @SuppressWarnings("all")
    private static <T> void setFieldUsingReflection(T object, String fieldName, String value, Class<T> clazz) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            if (field.getType().equals(String.class)) {
                field.set(object, value);
            } else {
                throw new IllegalArgumentException("Field " + fieldName + " is not of type String");
            }
        } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
            log.error("Failed to set field value via reflection: {}", e.getMessage(), e);
        }
    }

    private static String toCamelCase(String s) {
        String[] parts = s.split("_");
        StringBuilder camelCaseString = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            camelCaseString.append(parts[i].substring(0, 1).toUpperCase()).append(parts[i].substring(1).toLowerCase());
        }
        return camelCaseString.toString();
    }
}
