package com.spearmint.framework.excel;

import com.spearmint.framework.excel.writer.Exporter;
import com.spearmint.framework.excel.writer.FileExcelWriter;

import java.io.File;
import java.util.Collection;

/**
 * @author 33992
 * @date 2019/3/5 14:33
 */
public class Bloom {

    private Exporter exporter;

    public <T> Bloom export(Collection<T> data) {
        return this.export(Exporter.create(data));
    }

    private <T> Bloom export(Exporter<T> exporter) {
        this.exporter = exporter;
        return this;
    }

    public void writeAsFile(File file) {
        new FileExcelWriter(file).export(exporter);
    }

    public static Bloom bloom() {
        return new Bloom();
    }
}
