package de.creatronix.artist3k.controller.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDateFormatter {
	static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    public static Calendar dateString2Calendar(String s) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Date d1 = df.parse(s);
        cal.setTime(d1);
        return cal;
    }

    public static String calendar2DateString(Calendar cal) {
        return df.format(cal.getTime());
    }
}
