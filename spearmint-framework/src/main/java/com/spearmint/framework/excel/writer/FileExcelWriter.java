package com.spearmint.framework.excel.writer;

import com.spearmint.framework.excel.enums.ExcelType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 33992
 * @date 2019/3/7 11:33
 */
public class FileExcelWriter extends AbstractExcelWriter {

    private static Logger logger = LoggerFactory.getLogger(FileExcelWriter.class);

    private File savePath;

    public FileExcelWriter(File file) {
        this.savePath = file;
    }

    @Override
    public <T> void export(Exporter<T> exporter) {
        if (null != savePath) {
            ExcelType excelType = ExcelType.getExcelType(savePath.getName());
            exporter.setExcelType(excelType);
            try {
                this.export(exporter, new FileOutputStream(savePath));
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
