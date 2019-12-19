package com.jonas.file.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 【 excel导出对象 】
 *
 * @author shenjy 2018/06/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelModel extends BaseRowModel {
    @ExcelProperty(value = "序号", index = 0)
    private Integer id;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;
}
