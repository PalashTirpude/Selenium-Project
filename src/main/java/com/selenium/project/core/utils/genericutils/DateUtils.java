package com.selenium.project.core.utils.genericutils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public  static Date getDate(String date, String dateFormat) throws ParseException {
        Calendar calender=Calendar.getInstance(Locale.getDefault());
        DateFormat format=new SimpleDateFormat(dateFormat,Locale.getDefault());
        Date parsedDate =format.parse(date);
        calender.setTime(parsedDate);
        return calender.getTime();
    }

    public  static String getDate(int days, String dateFormat){
        Calendar calender=Calendar.getInstance(Locale.getDefault());
        DateFormat format=new SimpleDateFormat(dateFormat,Locale.getDefault());
        calender.add(Calendar.DATE,days);
        return format.format(calender.getTime());
    }

    public static String changeDateFormat(Date date,String newDateFormat){
        SimpleDateFormat sdf= new SimpleDateFormat(newDateFormat);
        return sdf.format(date);
    }
}
