package com.jonas.collection.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shenjy
 * @createTime 2022/2/21 11:18
 * @description 测试使用的员工类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int salary;
    private int age;
    private String sex;
    private String area;
}
