package com.spearmint.framework.excel.utils;

import com.spearmint.framework.excel.annotation.Excel;
import com.spearmint.framework.excel.annotation.ExcelField;
import com.spearmint.framework.excel.constant.Constant;
import com.spearmint.framework.excel.converter.Converter;
import com.spearmint.framework.excel.converter.EmptyConverter;
import com.spearmint.framework.utils.DateUtils;
import com.spearmint.framework.utils.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author 33992
 * @date 2019/3/5 16:31
 */
public class ExcelUtils {

    private ExcelUtils() {}

    public static String getSheetName(Object item) {
        Excel excel = item.getClass().getAnnotation(Excel.class);
        if (excel == null || StringUtils.isBlank(excel.sheetName())) {
            return Constant.SHEET_ZERO;
        }
        return excel.sheetName();
    }

    public static String getColumnValue(Object item, Field field) {
        try {
            field.setAccessible(true);
            Object value = field.get(item);
            return asString(field, value);
        } catch (Exception e) {
            return Constant.EMPTY_STRING;
        }
    }

    private static <T> String asString(Field field, T value) {
        if (value == null) {
            return Constant.EMPTY_STRING;
        }

        ExcelField excelField = field.getAnnotation(ExcelField.class);
        if (null != excelField && !excelField.convertType().equals(EmptyConverter.class)) {
            Converter converter = FieldUtils.newInstance(excelField.convertType());
            if (null != converter) {
                return Constant.EMPTY_STRING;
            }
        }

        if (value instanceof Date && null != excelField && !Constant.EMPTY_STRING.equals(excelField.datePattern())) {
            return DateUtils.toString((Date) value, excelField.datePattern());
        }
        return value.toString();
    }

    private static Object asObject(Field field, String value) {
        if (null == value || "".equals(value)) {
            return null;
        }
        ExcelField excelField = field.getAnnotation(ExcelField.class);
        if (null != excelField && !excelField.convertType().equals(EmptyConverter.class)) {
            Converter converter = FieldUtils.newInstance(excelField.convertType());
            if (null != converter) {
                return converter.read(value);
            }
        }
        if (field.getType().equals(String.class)) {
            return value;
        }
        if (field.getType().equals(BigDecimal.class)) {
            return new BigDecimal(value);
        }
        if (field.getType().equals(Long.class) || field.getType().equals(long.class)) {
            return Long.valueOf(value);
        }
        if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
            return Integer.valueOf(value);
        }
        if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
            return Double.valueOf(value);
        }
        if (field.getType().equals(Float.class) || field.getType().equals(float.class)) {
            return Float.valueOf(value);
        }
        if (field.getType().equals(Short.class) || field.getType().equals(short.class)) {
            return Short.valueOf(value);
        }
        if (field.getType().equals(Byte.class) || field.getType().equals(byte.class)) {
            return Byte.valueOf(value);
        }
        if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
            return Boolean.valueOf(value);
        }

        if (field.getType().equals(Date.class)) {
            if (null == excelField || Constant.EMPTY_STRING.equals(excelField.datePattern())) {
                return value;
            }
            return DateUtils.toDate(value, excelField.datePattern());
        }
        return value;
    }
}
