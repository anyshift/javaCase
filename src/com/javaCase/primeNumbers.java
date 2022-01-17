package com.javaCase;

/**
 * @author THRFUR
 * 求质数
 */

public class primeNumbers {
    public static void main(String[] args) {
        getPrimeNumbers(1000);
    }
    static void getPrimeNumbers(int num){
        for (int i = 2; i < num; i++){
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0) { //如果可以被j整除
                    flag = false;  //则i不是质数
                    break; //终止此次循环
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
    }
}
