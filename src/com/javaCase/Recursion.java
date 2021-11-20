package com.javaCase;

/**
 * @author THRFUR
 * 简单的案例，简单的递归
 */

public class Recursion {
    public static void main(String[] args) {
        System.out.println(getSum(10));
    }

    static int getSum(int num) {
        if (num == 1) return 1;
        else return num + getSum(num - 1);
    }
}
