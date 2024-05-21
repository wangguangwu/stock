package com.wangguangwu.datatushare.util;

import cn.hutool.core.text.CharSequenceUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

            Class<?> type = field.getType();
            if (type.equals(String.class)) {
                field.set(object, value);
            } else if (type.equals(int.class) || type.equals(Integer.class)) {
                field.set(object, value == null ? null : Integer.parseInt(value));
            } else if (type.equals(long.class) || type.equals(Long.class)) {
                field.set(object, value == null ? null : Long.parseLong(value));
            } else if (type.equals(float.class) || type.equals(Float.class)) {
                field.set(object, value == null ? null : Float.parseFloat(value));
            } else if (type.equals(double.class) || type.equals(Double.class)) {
                field.set(object, value == null ? null : Double.parseDouble(value));
            } else if (type.equals(boolean.class) || type.equals(Boolean.class)) {
                field.set(object, value == null ? null : Boolean.parseBoolean(value));
            } else if (type.equals(BigDecimal.class)) {
                field.set(object, value == null ? null : new BigDecimal(value));
            } else {
                throw new IllegalArgumentException("Field type " + type.getSimpleName() + " for " + fieldName + " is not supported.");
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

    @SuppressWarnings("all")
    public static <S, T> T convertWithTypeTransfer(S source, Class<T> targetClass) {
        T targetObject = null;
        try {
            targetObject = targetClass.getDeclaredConstructor().newInstance();
            copyFields(source, targetObject, targetClass);
        } catch (Exception e) {
            log.error("调用 convertWithTypeTransfer 方法异常: {}", e.getMessage(), e);
        }
        return targetObject;
    }

    private static <S, T> void copyFields(S source, T targetObject, Class<T> targetClass) throws IllegalAccessException {
        Field[] targetFields = targetClass.getDeclaredFields();
        Field[] sourceFields = source.getClass().getDeclaredFields();
        for (Field targetField : targetFields) {
            copyField(source, targetObject, sourceFields, targetField);
        }
    }

    private static <S, T> void copyField(S source, T targetObject, Field[] sourceFields, Field targetField) throws IllegalAccessException {
        targetField.setAccessible(true);
        Field sourceField = findField(sourceFields, targetField.getName());
        if (sourceField != null) {
            sourceField.setAccessible(true);
            assignField(source, targetObject, sourceField, targetField);
        }
    }

    private static <S, T> void assignField(S source, T targetObject, Field sourceField, Field targetField) throws IllegalAccessException {
        // Get the value as Object, and convert to String only if necessary
        Object rawValue = sourceField.get(source);
        String value = (rawValue != null) ? rawValue.toString() : null;

        if (value != null) {
            try {
                switch (targetField.getType().getName()) {
                    case "java.lang.String" -> targetField.set(targetObject, value);
                    case "int", "java.lang.Integer" -> targetField.set(targetObject, Integer.parseInt(value));
                    case "long", "java.lang.Long" -> targetField.set(targetObject, Long.parseLong(value));
                    case "double", "java.lang.Double" -> targetField.set(targetObject, Double.parseDouble(value));
                    case "float", "java.lang.Float" -> targetField.set(targetObject, Float.parseFloat(value));
                    case "boolean", "java.lang.Boolean" -> targetField.set(targetObject, Boolean.parseBoolean(value));
                    case "java.math.BigDecimal" -> targetField.set(targetObject, new BigDecimal(value));
                    case "java.time.LocalDate" -> targetField.set(targetObject, parseDate(value));
                    default ->
                            throw new IllegalArgumentException("Unsupported field type: " + targetField.getType().getName());
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                // Log or handle the error appropriately
                System.err.println("Error converting value for field " + targetField.getName() + ": " + e.getMessage());
            }
        }
    }

    private static Field findField(Field[] fields, String name) {
        for (Field field : fields) {
            if (field.getName().equals(name)) {
                return field;
            }
        }
        return null;
    }

    private static LocalDate parseDate(String dateStr) {
        if (CharSequenceUtil.isNotBlank(dateStr)) {
            try {
                return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
            } catch (DateTimeParseException e) {
                // 可以记录错误或进行其他错误处理
                log.error("Invalid date format: {}", dateStr);
                return null;
            }
        }
        return null;
    }
}
