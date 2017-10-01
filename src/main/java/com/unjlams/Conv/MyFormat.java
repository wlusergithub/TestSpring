package com.unjlams.Conv;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by UnjlAms on 2017/8/25.
 */
public class MyFormat implements Formatter<Date>{
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return null;
    }
}
