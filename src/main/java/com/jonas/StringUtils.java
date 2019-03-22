package com.jonas;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 字符串工具
 *
 * @author shenjy 2019/03/22
 */
public class StringUtils {

    /**
     * 字符串拼接
     *
     * @param list
     * @return
     */
    public static <T> String join(List<T> list, String separator) {
        if (CollectionUtils.isEmpty(list) || null == separator) {
            return "";
        }

        Joiner joiner = Joiner.on(separator).useForNull("null");
        return joiner.join(list);
    }

    /**
     * 字符串拆分
     *
     * @param source
     * @param separator
     * @param <T>
     * @return
     */
    public static <T> List<T> split(String source, String separator) {
        List<String> list = Splitter.on(separator)
                .trimResults()
                .omitEmptyStrings()
                .splitToList(source);

        return (List<T>) list;
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            list.add(null);
        }

        String source = join(list, ":");
        System.out.println(source);
        List<Integer> ints = split(source, ":");
        System.out.println(ints);
    }
}
