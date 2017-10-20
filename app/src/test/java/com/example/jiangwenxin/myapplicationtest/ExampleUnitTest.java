package com.example.jiangwenxin.myapplicationtest;

import android.text.format.DateUtils;
import android.widget.Toast;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {


        String trim = "21474836" + "00";
        String trim2 = "2147483647";
        System.out.print("\nendC=" + Integer.MAX_VALUE);
        System.out.print("\nendC=" + trim + ";" + trim.compareTo(trim2));

        assertEquals(4, 2 + 2);

    }


    public static String numberFormat(int fen) {
        BigDecimal bigDecimal = new BigDecimal(fen);
        BigDecimal divide = bigDecimal.divide(new BigDecimal(100));
        BigDecimal setScale = divide.setScale(2);
        DecimalFormat bf = new DecimalFormat("#,###.00");
        String decimalStr = bf.format(setScale).equals(".00") ? "0.00" : bf.format(setScale);
        if (decimalStr.startsWith(".")) {
            decimalStr = "0" + decimalStr;
        }else if(decimalStr.startsWith("-.")) {
            decimalStr = "-0" + decimalStr.substring(1);
        }
        return decimalStr;
    }


    public static String getCommentTime(long commentTime, long serverTime) {
        if(commentTime <= 0L) {
            return "-";
        } else {
            long diff = (serverTime - commentTime) / 1000L;
            if(diff <= 60L) {
                return "刚刚";
            } else if(diff <= 3600L) {
                return diff / 60L + "分钟前";
            } else {
//                Calendar.MINUTE
                Calendar commentCalendar = Calendar.getInstance();
                commentCalendar.setTimeInMillis(commentTime);
                Calendar serverCalendar = Calendar.getInstance();
                serverCalendar.setTimeInMillis(serverTime);
                if(serverCalendar.get(Calendar.YEAR) == commentCalendar.get(Calendar.YEAR)) {
                    int dayDiff = serverCalendar.get(Calendar.DAY_OF_YEAR) - commentCalendar.get(Calendar.DAY_OF_YEAR);
                    return dayDiff == 0?String.format(Locale.getDefault(), "%02d:%02d",
                            new Object[]{Integer.valueOf(commentCalendar.get(Calendar.HOUR_OF_DAY)),
                                    Integer.valueOf(commentCalendar.get(Calendar.MINUTE))}):
                            (dayDiff == 1?"昨天":String.format(Locale.getDefault(),
                                    "%02d-%02d", new Object[]{Integer.valueOf(commentCalendar.get(Calendar.MONTH) + 1),
                                            Integer.valueOf(commentCalendar.get(Calendar.DATE))}));
                } else {
                    return String.format(Locale.getDefault(), "%d-%02d-%02d",
                            new Object[]{Integer.valueOf(commentCalendar.get(Calendar.YEAR)),
                                    Integer.valueOf(commentCalendar.get(Calendar.MONTH) + 1),
                                    Integer.valueOf(commentCalendar.get(Calendar.DATE))});
                }
            }
        }
    }

}