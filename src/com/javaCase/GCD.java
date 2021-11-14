package com.javaCase;

import java.util.Scanner;

/**
 * @author THRFUR
 * 最大公约数【Greatest Common Divisor(GCD)】，因此用GCD代表最大公约数。
 */

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        GCD2 gcd = new GCD2(num1, num2);
        System.out.println(gcd.getGCD2(num1, num2));
    }
}

/**
 * 方法一：辗转相除之递归调用法
 * 两数相除，若余数为零，则最大公约数为两数中最小值；若余数不为零，则取两数之余，并递归调用，直到余数为零。
 */

class GCD1 {
    private int a, b;
    public GCD1(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int getGCD1(int num1, int num2) {
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        if (num1 < num2) { int temp = num1; num1 = num2; num2 = temp; } //确保num1是最大值
        int remainder = num1 % num2;
        if (remainder == 0) return num2;
        return getGCD1(num1, remainder); //最大值与余数辗转相除取余，直到余数为零
    }
}

/**
 * 方法二：辗转相除之非递归法
 */
class GCD2 {
    private int a, b;
    public GCD2(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int getGCD2(int num1, int num2) {
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        return num1;
    }
}

// TODO:其它方法