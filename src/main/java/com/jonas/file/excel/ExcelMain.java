package com.jonas.file.excel;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 【 excel导出测试类 】
 *
 * @author shenjy 2018/06/21
 */
public class ExcelMain {

    private static int NUM = 25000;

    public static void main(String[] args) {
        List<ExcelModel> data = Lists.newArrayList();
        for (int i = 0; i < NUM; i++) {
            data.add(new ExcelModel(i+1, "Tom" + i));
        }

        new ExportExcel<ExcelModel>().export(data, "用户信息表", ExcelModel.class);
    }
}
