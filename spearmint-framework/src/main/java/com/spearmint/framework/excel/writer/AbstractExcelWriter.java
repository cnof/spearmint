package com.spearmint.framework.excel.writer;

import com.spearmint.framework.excel.constant.DefaultStyle;
import com.spearmint.framework.excel.enums.ExcelType;
import com.spearmint.framework.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

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
    public <T> void export(Exporter<T> exporter, OutputStream outputStream) throws Exception {
        Collection<T> data = exporter.getData();
        try (Workbook workbook = createWorkbook(exporter)) {
            Sheet sheet;

            T data0 = data.iterator().next();
        }
    }

    public <T> Workbook createWorkbook(Exporter<T> exporter) throws Exception {
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
}
