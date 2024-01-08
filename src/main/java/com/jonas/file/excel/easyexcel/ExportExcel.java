package com.jonas.file.excel.easyexcel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 【 Excel导出工具类 】
 *
 * @author shenjy 2018/06/21
 */
public class ExportExcel<T extends BaseRowModel> {

    private static int SHEET_SIZE = 10000;

    public void export(List<T> data, String title, Class clazz) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(title + ExcelTypeEnum.XLSX.getValue());
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

            int size = data.size();
            int page = size / SHEET_SIZE + 1;

            for (int i = 0; i < page; i++) {
                int toIndex = (i + 1) * SHEET_SIZE - 1;
                if (toIndex > size) {
                    toIndex = size;
                }
                Sheet sheet = new Sheet(i + 1, 0, clazz);
                writer.write(data.subList(i * SHEET_SIZE, toIndex), sheet);
            }

            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
