package com.javaCase;

/**
 * 设n是一个4位数，它的9倍正好是其反序数，求N。反序数就是将整数的数字倒过来形成的数。
 */

public class ReverseOrder {
    public static void main(String[] args) {
        for (int i = 1000; i<=9999; i++) {
            if (i*9 == reverse(i)) {
                System.out.println(i);
                break; // 求一个就行，有就终止
            }
        }
    }
    static int reverse(int n) {
        int reversed = 0; // 存放反转后的数
        if (n/1000 <= 0) return 0; // 如果n不是4位数，返回0
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10; // 让n不断变小
        }
        return reversed; // 返回反转后的数
    }
}
