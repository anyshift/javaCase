package com.javaCase;

/**
 * N至少多大时，不等式成立：1/1+1/2+1/3+···+1/n > 6
 */

public class GetN {
    public static void main(String[] args) {
        getN();
    }
    static void getN() {
        double sum = 1.0; // sum是小数，默认赋值（1.0/1）的值
        for (int n = 2;; n++) { // 从（1.0/2）开始
            sum += 1.0 / n; // 1/1+1/2+1/3+···+1/n
            if (sum > 6) { // 如果总数大于6
                System.out.println(n);
                break; // 确保"至少多大"这个条件
            }
        }
    }
}
