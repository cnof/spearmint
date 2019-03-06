package com.spearmint.framework.excel.model;

import com.spearmint.framework.excel.annotation.Special;
import com.spearmint.framework.excel.converter.Converter;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 33992
 * @date 2019/3/6 16:56
 */
@Data
public class ExcelFieldResult implements Serializable {

    private Integer columnOrder;

    private String columnName;

    private String datePattern;

    private Class<? extends Converter> convertType;

    private Special special;
}
