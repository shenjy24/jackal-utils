package com.jonas.convert;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author shenjiayun
 * @since 2020-01-06
 */
public class DateEditor extends PropertyEditorSupport {
    private DateFormat dateFormat;

    public DateEditor(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(dateFormat.parse(text));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return null != value ? dateFormat.format(value) : "";
    }
}
