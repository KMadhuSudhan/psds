package com.madhu.psds.calendar;

public class DayofTheYear {
    public static void main(String[] args) {
        DayofTheYear dayofTheYear = new  DayofTheYear();
        System.out.println(5<< 2);
       // System.out.println( dayofTheYear.dayOfYear("1900-03-25"));
    }
    public int dayOfYear(String date) {
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");

        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        int res = 0;

        boolean isLeap = ((year % 4 == 0) && (year % 100 != 0)) ||
                (year % 400 == 0);

        if(isLeap) days[1] = 29;

        for(int i = 0; i < month-1; i++) {
            res += days[i];
        }
        return res+day;
    }
}
