package com.spearmint.framework.excel.annotation;

import com.spearmint.framework.excel.constant.Constant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 33992
 * @date 2019/3/5 16:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Excel {

    String sheetName() default Constant.SHEET_ZERO;
}
