package com.jonas.collection;

import lombok.Getter;

/**
 * 区间枚举
 *
 * @author
 */
@Getter
public enum RangeType {

    CLOSE(1, "闭区间"),
    OPEN(2, "开区间"),
    OPEN_CLOSE(3, "开闭区间"),
    CLOSE_OPEN(4, "闭开区间")
    ;

    private Integer code;
    private String message;

    RangeType(Integer type, String message) {
        this.code = type;
        this.message = message;
    }
}


