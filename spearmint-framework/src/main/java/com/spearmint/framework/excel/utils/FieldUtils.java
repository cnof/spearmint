package com.spearmint.framework.excel.utils;

import com.spearmint.framework.excel.annotation.ExcelField;
import com.spearmint.framework.utils.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 33992
 * @date 2019/3/6 17:00
 */
public class FieldUtils {

    private FieldUtils() {}

    public static Map<String, Integer> getSpecialFieldNameAndRowMap(Class<?> type) {
        List<Field> fields = getAndSaveFields(type);
        Map<String, Integer> map = new HashMap<>();
        fields.forEach(field -> {
            ExcelField excelField = field.getAnnotation(ExcelField.class);
            if (excelField.special().isSpecial()) {
                map.put(excelField.columnName(), excelField.special().specialRowNum());
            }
        });
        return map;
    }

    public static Map<String, Integer> getFieldNameAndColMap(Class<?> type) {
        List<Field> fields = getAndSaveFields(type);
        Map<String, Integer> map = new HashMap<>(12);
        fields.stream().filter(u -> -999 != u.getAnnotation(ExcelField.class).columnOrder())
                .forEach(field -> {
                    ExcelField excelField = field.getAnnotation(ExcelField.class);
                    if (excelField.special().isSpecial()) {
                        map.put(excelField.columnName(), excelField.special().specialColNum());
                    } else {
                        map.put(excelField.columnName(), excelField.columnOrder());
                    }
                });
        return map;
    }

    public static List<Field> getAndSaveFields(Class<?> clazz) {
        List<Field> fields = getFieldList(clazz);
        return fields.stream().filter(u -> null != u.getAnnotation(ExcelField.class))
                .filter(s -> StringUtils.isNotBlank(s.getAnnotation(ExcelField.class).columnName()))
                .collect(Collectors.toList());
    }

    public static <T> T newInstance(Class<T> type) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    private static List<Field> getFieldList(Class<?> clazz) {
        List<Field> list = new ArrayList<>();
        if (null == clazz) {
            return list;
        }
        if (null != clazz.getSuperclass()) {
            list.addAll(getFieldList(clazz.getSuperclass()));
        }
        Field[] fields = clazz.getDeclaredFields();
        if (null != fields) {
            list.addAll(Arrays.asList(fields));
        }

        return list;
    }
}
