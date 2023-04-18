package com.jonas.file.excel.poi;

import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 处理大量数据时可能内存溢出
 */
public class XSSFExcel {

    public static void export(int num) {
        String[] title = {"id", "name", "sex"};
        // 创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        // 创建一个工作表sheet
        Sheet sheet = workbook.createSheet();
        // 创建第一行
        Row row = sheet.createRow(0);
        // 创建一个单元格
        Cell cell = null;
        // 创建表头
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        // 从第二行开始追加数据
        for (int i = 1; i <= 50000; i++) {
            // 创建第i行
            Row nextRow = sheet.createRow(i);
            // 参数代表第几列
            Cell cell2 = nextRow.createCell(0);
            cell2.setCellValue("a" + i);
            cell2 = nextRow.createCell(1);
            cell2.setCellValue("user" + i);
            cell2 = nextRow.createCell(2);
            cell2.setCellValue("男");
        }
        // 创建一个文件
        File file = new File("xssf" + ExcelTypeEnum.XLSX.getValue());
        try {
            file.createNewFile();
            // 打开文件流
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("创建完成");
            System.out.println("总的内存->" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "MB");
            System.out.println("剩余的内存->" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "MB");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
