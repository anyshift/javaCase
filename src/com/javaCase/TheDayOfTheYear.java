package com.javaCase;

/**
 * @author thrfur
 * 计算今天是今年的第几天
 */

public class TheDayOfTheYear {
    public static void main(String[] args) {
        int year = 2021; int month = 12; int day = 22;
        DayYear dayYear = new DayYear();
        System.out.println(dayYear.dayInYear(year,month,day));
    }
}
class DayYear{
    boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
    int dayInYear(int year,int month,int day){
        int countDay = 0;
        for (int i = month -1; i > 0; i--) {
            switch (i) {
                case 1: case 3: case 5: case 7: case 8: case 10:
                    countDay += 31;
                    break;
                case 4: case 6: case 9: case 11:
                    countDay += 30;
                    break;
                case 2:
                    if (isLeap(year)) { countDay+=29; } else countDay+=28;
                    break;
            }
        }
        return countDay + day;
    }
}
