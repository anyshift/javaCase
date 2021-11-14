package com.javaCase;

import java.util.Scanner;

/**
 * @author THRFUR
 * 最大公约数：Least Common Multiple(LCM)
 */

public class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        LCM1 lcm = new LCM1(a, b);
        System.out.println(lcm.getLCM1());
    }
}

/**
 * 方法一：公式法
 * (a,b）×[a,b]=a×b
 * a与b的最大公约数 × a与b最小公倍数 = a×b
 * 即：a与b最小公倍数 = (a×b) / a与b的最大公约数
 */

class LCM1 {
    private int x, y;
    public LCM1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getLCM1(){
        return x*y/getGCD(x,y); //套公式
    }

    /**
     * getGCD 获取最大公约数
     * @param num1 形参1
     * @param num2 形参2
     * @return 最大公约数(int)
     */
    public int getGCD(int num1, int num2) {
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        if (num1 < num2) { int temp = num1; num1 = num2; num2 = temp; } //确保num1是最大值
        int remainder = num1 % num2;
        if (remainder == 0) return num2;
        return getGCD(num1, remainder); //最大值与余数辗转相除取余，直到余数为零
    }
}

// TODO：分解质因数法