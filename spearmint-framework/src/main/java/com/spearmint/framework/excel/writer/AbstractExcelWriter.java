package com.spearmint.framework.excel.writer;

import com.spearmint.framework.excel.annotation.ExcelField;
import com.spearmint.framework.excel.constant.DefaultStyle;
import com.spearmint.framework.excel.enums.ExcelType;
import com.spearmint.framework.excel.utils.ExcelUtils;
import com.spearmint.framework.excel.utils.FieldUtils;
import com.spearmint.framework.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 数据写入
 * @author 33992
 * @date 2019/3/5 15:51
 */
public abstract class AbstractExcelWriter implements DefaultStyle {

    public static final ExpressionParser PARSER = new SpelExpressionParser();

    public static final StandardEvaluationContext CONTEXT = new StandardEvaluationContext();

    /**
     * 默认的导出方法
     * @param exporter Exporter 对象
     * @param outputStream 输出流
     * @param <T> Java 类型
     */
    public <T> void export(Exporter<T> exporter, OutputStream outputStream) throws IOException {
        Collection<T> data = exporter.getData();
        try (Workbook workbook = createWorkbook(exporter)) {
            Sheet sheet;
            CellStyle titleStyle;
            CellStyle headerStyle;
            CellStyle columnStyle;

            T data0 = data.iterator().next();

            Iterator<T> iterator = data.iterator();
            Map<String, Integer> writeFieldNames = FieldUtils.getFieldNameAndColMap(data0.getClass());
            int startRow = exporter.getStartRow();

            sheet = workbook.createSheet(ExcelUtils.getSheetName(data0));
            if (null != exporter.getTitleStyle()) {
                titleStyle = exporter.getTitleStyle().apply(workbook);
            } else {
                titleStyle = defaultTitleStyle(workbook);
            }

            if (null != exporter.getHeaderStyle()) {
                headerStyle = exporter.getHeaderStyle().apply(workbook);
            } else {
                headerStyle = defaultHeaderStyle(workbook);
            }

            if (null != exporter.getColumnStyle()) {
                columnStyle = exporter.getColumnStyle().apply(workbook);
            } else {
                columnStyle = defaultColumnStyle(workbook);
            }

            String headerTitle = exporter.getHeaderTitle();
            int colIndex = 0;
            if (null != headerTitle) {
                colIndex = 1;
                this.writeTitleRow(headerStyle, sheet, headerTitle, writeFieldNames.keySet().size());
            }
            this.writeColumnNames(colIndex, titleStyle, sheet, writeFieldNames);
            this.writeRows(sheet, columnStyle, iterator, writeFieldNames, startRow);
            workbook.write(outputStream);
        }
    }

    private <T> Workbook createWorkbook(Exporter<T> exporter) throws IOException {
        if (StringUtils.isNotBlank(exporter.getTemplatePath())) {
            InputStream in = AbstractExcelWriter.class.getClassLoader()
                    .getResourceAsStream(exporter.getTemplatePath());
            if (null == in) {
                in = new FileInputStream(exporter.getTemplatePath());
            }
            return WorkbookFactory.create(in);
        } else {
            return exporter.getExcelType().equals(ExcelType.XLSX) ? new SXSSFWorkbook()
                    : new HSSFWorkbook();
        }
    }

    private void writeTitleRow(CellStyle cellStyle, Sheet sheet, String title, int maxColIndex) {
        Row titleRow = sheet.createRow(0);
        for (int i = 0; i <= maxColIndex; i++) {
            Cell cell = titleRow.createCell(i);
            if (i == 0) {
                cell.setCellValue(title);
            }
            cell.setCellStyle(cellStyle);
        }
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, maxColIndex));
    }

    private void writeColumnNames(int rowIndex, CellStyle cellStyle, Sheet sheet, Map<String, Integer> columnNames) {
        Row rowHead = sheet.createRow(rowIndex);
        columnNames.keySet().forEach(key -> {
            Cell cell = rowHead.createCell(columnNames.get(key));
            if (null != cellStyle) {
                cell.setCellStyle(cellStyle);
            }
            cell.setCellValue(key);
        });
    }

    private <T> void writeRows(Sheet sheet, CellStyle columnStyle, Iterator<T> iterator
            , Map<String, Integer> writeFieldNames, int startRow) {
        for (int rowNum = startRow; iterator.hasNext(); rowNum++) {
            T item = iterator.next();
            Row row = sheet.createRow(rowNum);
            List<Field> fields = FieldUtils.getAndSaveFields(item.getClass());
            fields.forEach(field -> {
                ExcelField excelField = field.getAnnotation(ExcelField.class);
                Integer colNum = writeFieldNames.get(excelField.columnName());
                if (null != colNum) {
                    field.setAccessible(true);
                    Cell cell = row.createCell(colNum);
                    String value = ExcelUtils.getColumnValue(item, field);
                    cell.setCellValue(value);
                    cell.setCellStyle(columnStyle);
                }
            });
        }
    }

    /**
     * 导出
     * @param exporter Exporter对象
     * @param <T> 实体
     */
    abstract <T> void export(Exporter<T> exporter);
}
