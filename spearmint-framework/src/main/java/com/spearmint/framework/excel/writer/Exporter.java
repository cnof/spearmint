package com.spearmint.framework.excel.writer;

import com.spearmint.framework.excel.enums.ExcelType;
import com.spearmint.framework.excel.model.ValidResult;
import lombok.Data;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author 33992
 * @date 2019/3/5 15:41
 */
@Data
public class Exporter<T> {

    private String headerTitle;
    private String templatePath;
    private ExcelType excelType;
    private Collection<T> data;
    private Map<Integer, Object> dataMap;
    private List<ValidResult> results;
    private int startRow = 1;

    private Function<Workbook, CellStyle> titleStyle;
    private Function<Workbook, CellStyle> headerStyle;
    private Function<Workbook, CellStyle> columnStyle;

    public static <T> Exporter<T> create(Collection<T> data) {
        Exporter<T> exporter = new Exporter<>();
        exporter.setData(data);
        return exporter;
    }
}
