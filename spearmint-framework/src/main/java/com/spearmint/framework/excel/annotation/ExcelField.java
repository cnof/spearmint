package com.spearmint.framework.excel.annotation;

import com.spearmint.framework.excel.constant.Constant;
import com.spearmint.framework.excel.converter.Converter;
import com.spearmint.framework.excel.converter.EmptyConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 33992
 * @date 2019/3/5 14:50
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelField {

    /**
     * excel列号顺序(必填，从0开始)
     * @return 列号
     */
    int columnOrder() default Constant.DEFAULT_ORDER;

    String columnName() default Constant.EMPTY_STRING;

    /**
     * Excel字段日期格式化
     * @return 字段格式化后的字符串
     */
    String datePattern() default Constant.EMPTY_STRING;

    /**
     * Excel字段类型转换器
     * @return 类型转换器
     */
    Class<? extends Converter> convertType() default EmptyConverter.class;

    /**
     * 是否为特殊字段(默认false)
     * @return 特殊注解
     */
    Special special() default @Special();
}
