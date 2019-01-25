package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 82646 on 2019/1/24.
 * 用来处理和时间有关的操作
 */
public class DateUtil {

    public static String getNewDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = format.format(date);

        return dateString;

    }

    //不同的角色传入不同的日期
    public static String addMonth(String date,int month){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String reStr = "";
        try{
            Date dt = sdf.parse(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.MONTH, 1);
            Date dt1 = rightNow.getTime();
            reStr = sdf.format(dt1);
        }catch (ParseException ex){
            ex.printStackTrace();
        }

        return reStr;
    }

    //计算两个日期相差的天数
    public static int getDays(String date1,String date2) throws ParseException{

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date start = df.parse(date1);
        Date end = df.parse(date2);

        return (int) ((df.parse(df.format(end)).getTime() -df.parse(df.format(start)).getTime()) / (24 * 60 * 60 * 1000));

    }
}
