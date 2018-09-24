package com.waspar.persiandatepicker.util;

public  class InitDate {

    public static String inputPersianDate(int Day , int Month , int Year){

        String month;
        String day;

        if (Month <= 9) {
            month = "0" + Month;
        } else {
            month = String.valueOf(Month);
        }

        if (Day <= 9) {
            day = "0" + Day;
        } else {
            day = String.valueOf(Day);
        }
        return Year + "/" + month + "/" + day;
    }
}
