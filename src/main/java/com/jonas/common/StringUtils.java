package com.jonas.common;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;

import static cn.hutool.core.util.StrUtil.replace;
import static cn.hutool.core.util.StrUtil.utf8Str;

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

    /**
     * 格式化文本，使用 <delimiter>varName<delimiter> 占位<br>
     * map = {a: "aValue", b: "bValue"} format("%a% and %b%", map， "%") ---=》 aValue and bValue
     *
     * @param template 文本模板，被替换的部分用 {key} 表示
     * @param map 参数值对
     * @return 格式化后的文本
     */
    public static String format(CharSequence template, Map<?, ?> map, String delimiter) {
        if (null == template) {
            return null;
        }
        if (null == map || map.isEmpty()) {
            return template.toString();
        }

        String template2 = template.toString();
        String value;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            value = utf8Str(entry.getValue());
            if (null != value) {
                template2 = replace(template2, delimiter + entry.getKey() + delimiter, value);
            }
        }
        return template2;
    }
}
