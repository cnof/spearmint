package com.spearmint.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 33992
 * @date 2019/3/5 16:50
 */
public class DateUtils {

    private DateUtils() {}

    public static Date toDate(String value, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String toString(Date value, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(value);
    }
}
