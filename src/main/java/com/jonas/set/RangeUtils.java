package com.jonas.set;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

/**
 * 区间工具类
 *
 * @author shenjy 2019/03/22
 */
public class RangeUtils {

    /**
     * 创建区间
     *
     * @param start
     * @param end
     * @param rangeType
     * @param <T>
     * @return
     */
    public static <T extends Comparable> Range<T> create(T start, T end, RangeType rangeType) {
        Range<T> range;
        switch (rangeType) {
            case OPEN:
                range = Range.open(start, end);
                break;
            case CLOSE:
                range = Range.closed(start, end);
                break;
            case CLOSE_OPEN:
                range = Range.closedOpen(start, end);
                break;
            case OPEN_CLOSE:
                range = Range.openClosed(start, end);
                break;
            default:
                range = null;
                break;
        }

        return range;
    }

    private static void printRange(Range<Integer> range) {
        System.out.print("[ ");
        for (int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.print(grade + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Range<Integer> range = create(1, 10, RangeType.CLOSE);
        printRange(range);
        System.out.println(range.upperEndpoint());
    }
}
