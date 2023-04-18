package com.jonas.file.excel;

import com.google.common.collect.Lists;
import com.jonas.file.excel.easyexcel.ExcelModel;
import com.jonas.file.excel.easyexcel.ExportExcel;
import com.jonas.file.excel.poi.SXSSFExcel;
import com.jonas.file.excel.poi.XSSFExcel;

import java.util.List;

/**
 * 【 excel导出测试类 】
 *
 * @author shenjy 2018/06/21
 */
public class ExcelMain {

    private static final int NUM = 500000;

    public static void testEasyExcel() {
        long startTime = System.currentTimeMillis();
        List<ExcelModel> data = Lists.newArrayList();
        for (int i = 0; i < NUM; i++) {
            data.add(new ExcelModel(i + 1, "Tom" + i));
        }

        new ExportExcel<ExcelModel>().export(data, "用户信息表", ExcelModel.class);
        long endTime = System.currentTimeMillis();
        System.out.println("EasyExcel cost: " + (endTime - startTime));
    }

    public static void testSXSSFExcel() {
        long startTime = System.currentTimeMillis();
        SXSSFExcel.export(NUM);
        long endTime = System.currentTimeMillis();
        System.out.println("SXSSFExcel cost: " + (endTime - startTime));
    }

    public static void testXSSFExcel() {
        long startTime = System.currentTimeMillis();
        XSSFExcel.export(NUM);
        long endTime = System.currentTimeMillis();
        System.out.println("XSSFExcel cost: " + (endTime - startTime));
    }

    public static void main(String[] args) {
//        testEasyExcel();
//        testSXSSFExcel();
        testXSSFExcel();
    }
}
