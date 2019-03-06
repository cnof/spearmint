package com.spearmint.framework.excel.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 33992
 * @date 2019/3/5 15:37
 */
@Data
@AllArgsConstructor
public class ValidResult {

    /**
     * 行号
     */
    private Integer rowNum;

    /**
     * 列号
     */
    private Integer colNum;

    /**
     * 基础数据校验信息
     */
    private String msg;
}
