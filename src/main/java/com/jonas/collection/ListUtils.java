package com.jonas.collection;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 列表工具类
 *
 * @author shenjy 2019/03/21
 */
public class ListUtils {

    /**
     * 获取列表最后元素
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getLast(List<T> list) {
        T last = Iterables.getLast(list);
        return last;
    }

    /**
     * 获取element在list的频率
     *
     * @param list
     * @param element
     * @return
     */
    public static <T> Integer getFrequency(List<T> list, T element) {
        Integer frequency = Iterables.frequency(list, element);
        return frequency;
    }

    /**
     * source集合保留retain集合中的元素
     *
     * @param source
     * @param retain
     */
    public static <T> List<T> retainAll(List<T> source, List<T> retain) {
        List<T> list = Lists.newArrayList(source);
        Iterables.retainAll(list, retain);
        return list;
    }

    /**
     * 判断source列表是否包含element元素
     *
     * @param source
     * @param element
     * @return
     */
    public static <T> boolean contains(List<T> source, T element) {
        return Iterables.contains(source, element);
    }

    /**
     * reverse数组
     *
     * @param source
     * @return
     */
    public static <T> List<T> reverse(List<T> source) {
        return Lists.reverse(source);
    }

    /**
     * 获取列表最大值
     *
     * @param source
     * @param <T>
     * @return
     */
    public static <T> T getMax(List<T> source) {
        Ordering ordering = Ordering.natural();
        return (T) ordering.max(source);
    }

    /**
     * 获取列表最小值
     *
     * @param source
     * @param <T>
     * @return
     */
    public static <T> T getMin(List<T> source) {
        Ordering ordering = Ordering.natural();
        return (T) ordering.min(source);
    }

    /**
     * 列表排序
     *
     * @param source
     * @param <T>
     * @return
     */
    public static <T> List<T> sort(List<T> source) {
        List<T> list = new ArrayList<>(source);
        Ordering ordering = Ordering.natural();
        Collections.sort(list, ordering);
        return list;
    }

    /**
     * 列表反向排序
     *
     * @param source
     * @param <T>
     * @return
     */
    public static <T> List<T> reverseSort(List<T> source) {
        List<T> list = new ArrayList<>(source);
        Ordering ordering = Ordering.natural();
        Collections.sort(list, ordering.reverse());
        return list;
    }

    /**
     * 列表是否排序
     *
     * @param source
     * @param <T>
     * @return
     */
    public static <T> boolean isSorted(List<T> source) {
        Ordering ordering = Ordering.natural();
        return ordering.isOrdered(source);
    }

    /**
     * 数组转换为List
     *
     * @param list
     * @return
     */
    public static Integer[] toIntArray(List<Integer> list) {
        return list.toArray(new Integer[list.size()]);
    }

    /**
     * 数组转换为List
     *
     * @param list
     * @return
     */
    public static String[] toStringArray(List<String> list) {
        return list.toArray(new String[list.size()]);
    }

    /**
     * 集合差集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> diffSet(List<T> list1, List<T> list2) {
        List<T> l1 = Lists.newArrayList(list1);
        List<T> l2 = Lists.newArrayList(list2);
        l1.removeAll(l2);
        return Lists.newArrayList(l1);
    }

    /**
     * 集合交集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> interSet(List<T> list1, List<T> list2) {
        return org.apache.commons.collections.ListUtils.retainAll(list1, list2);
    }

    /**
     * 集合不重复并集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> unionSet(List<T> list1, List<T> list2) {
        List<T> l1 = Lists.newArrayList(list1);
        List<T> l2 = Lists.newArrayList(list2);
        l1.addAll(l2);
        return Lists.newArrayList(Sets.newHashSet(l1));
    }

    /**
     * 获取某个列表的子集，增加越界处理
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @param source    source list
     * @param <T>
     * @return a view of the specified range within this list
     */
    public static <T> List<T> subList(int fromIndex, int toIndex, List<T> source) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");

        toIndex = Math.min(toIndex, source.size());
        return source.subList(fromIndex, toIndex);
    }
}
