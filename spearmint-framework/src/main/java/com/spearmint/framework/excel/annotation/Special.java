package com.spearmint.framework.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 33992
 * @date 2019/3/5 16:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Special {

    /**
     * 是否为特殊字段,默认false
     * @return true/false
     */
    boolean isSpecial() default false;

    /**
     * 特殊字段列号
     * @return 列号
     */
    int specialColNum() default -1;

    /**
     * 特殊字段行号
     * @return 行号
     */
    int specialRowNum() default -1;
}
