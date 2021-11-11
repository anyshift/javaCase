package com.javaCase;

import java.util.Scanner;

/**
 * @author THRFUR
 * 计算闰年
 */

public class leapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        leapCheck leap = new leapCheck(year);
        if (leap.isLeapOrNot()) {
            System.out.println(year + " is leap year.");
        }else System.out.println(year + " is not leap year.");
    }
}

class leapCheck {
    private int year;

    public leapCheck(int year){
        this.year = year;
    }

    public boolean isLeapOrNot(){
        // 四年一闰 百年不闰 四百年再闰
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}