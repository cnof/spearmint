package com.spearmint.framework.excel.constant;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

/**
 * @author 33992
 * @date 2019/3/5 14:57
 */
public interface DefaultStyle {

    /**
     * 默认 excel 标题
     * @param workbook workbook
     * @return 标题样式
     */
    default CellStyle defaultTitleStyle(Workbook workbook) {

        CellStyle style = workbook.createCellStyle();
        defaultStyle(style);
        defaultFontStyle(workbook, style);
        return style;
    }

    /**
     * 默认Excel行头样式.
     *
     * @param workbook workbook对象
     * @return Excel行头样式
     */
    default CellStyle defaultHeaderStyle(Workbook workbook) {

        CellStyle headerStyle = workbook.createCellStyle();
        defaultStyle(headerStyle);
        defaultFontStyle(workbook, headerStyle);
        return headerStyle;
    }

    /**
     * 默认单元格样式
     *
     * @param workbook workbook对象
     * @return 单元格样式
     */
    default CellStyle defaultColumnStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();

        defaultAlignmentStyle(cellStyle);
        defaultBorderStyle(cellStyle);
        cellStyle.setWrapText(true);

        Font font = workbook.createFont();
        font.setFontName("Arial");
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     * 默认单元格样式
     * @param style 单元格样式
     */
    default void defaultStyle(CellStyle style) {
        defaultAlignmentStyle(style);
        defaultBorderStyle(style);
        defaultFillStyle(style);
    }

    /**
     * 单元格边框样式
     * @param style 单元格
     */
    default void defaultBorderStyle(CellStyle style) {
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
    }

    /**
     * 默认单元格内容位置样式
     * @param style 单元格
     */
    default void defaultAlignmentStyle(CellStyle style) {
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
    }

    /**
     * 默认单元格填充样式
     * @param style 单元格
     */
    default void defaultFillStyle(CellStyle style) {
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    }

    /**
     * 默认字体样式
     * @param workbook workbook
     * @param style 单元格
     */
    default void defaultFontStyle(Workbook workbook, CellStyle style) {
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        font.setFontName("Arial");
        style.setFont(font);
    }
}
