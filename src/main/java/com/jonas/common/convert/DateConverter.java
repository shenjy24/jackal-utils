package com.jonas.common.convert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author shenjiayun
 * @since 2020-01-06
 */
public class DateConverter {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static DateEditor dateEditor = new DateEditor(dateFormat);

    public static Date getDate(String str) {
        dateEditor.setAsText(str);
        return (Date) dateEditor.getValue();
    }

    public static String getStr(Date date) {
        dateEditor.setValue(date);
        return dateEditor.getAsText();
    }

}
