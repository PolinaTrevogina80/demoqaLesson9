package utils;

import java.util.Calendar;

public class DateUtils {

    public static String convertMonthToText(Integer month) {

        return switch (month) {
            case Calendar.JANUARY -> "January";
            case Calendar.FEBRUARY -> "February";
            case Calendar.MARCH -> "March";
            case Calendar.APRIL -> "April";
            case Calendar.MAY -> "May";
            case Calendar.JUNE -> "June";
            case Calendar.JULY -> "July";
            case Calendar.AUGUST -> "August";
            case Calendar.SEPTEMBER -> "September";
            case Calendar.OCTOBER -> "October";
            case Calendar.NOVEMBER -> "November";
            case Calendar.DECEMBER -> "December";
            default -> "";
        };
    }
}
