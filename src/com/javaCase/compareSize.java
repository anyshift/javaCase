package com.javaCase;

import java.util.Scanner;

/**
 * @author THRFUR
 * 为了每日一case而push的case。。。
 */

public class compareSize {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int a = Sc.nextInt(); int b = Sc.nextInt(); int c = Sc.nextInt(); int temp;
        if (a > b) { temp = a; a = b; b = temp; }
        if (a > c) { temp = a; a = c; c = temp; }
        if (b > c) { temp = b; b = c; c = temp; }
        System.out.println(a + "<" + b + "<" + c);
    }
}
