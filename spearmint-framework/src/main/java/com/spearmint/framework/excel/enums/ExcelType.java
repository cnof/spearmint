package com.spearmint.framework.excel.enums;

/**
 * @author 33992
 * @date 2019/3/5 15:39
 */
public enum ExcelType {

    /**
     * xls
     */
    XLS,

    /**
     * xlsx
     */
    XLSX;

    public static ExcelType getExcelType(String fileName) {
        if (fileName.toUpperCase().endsWith(XLS.toString())) {
            return ExcelType.XLS;
        }
        if (fileName.toUpperCase().endsWith(XLSX.toString())) {
            return ExcelType.XLSX;
        }
        return ExcelType.XLS;
    }
}
