package hw.d10092021.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateCalculate {

    public static long getMillisByPattern(String pattern){
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat(pattern);  //  Locale.getDefault()
        String str =dateFormat.format(currentDate);
        long result = 0;
        try {
            result = dateFormat.parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
    public static String getViewByPattern(String pattern, long time){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.forLanguageTag("en"));
        return formatter.format(new Date(time));
    }
}
// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html