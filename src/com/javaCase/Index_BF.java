package com.javaCase;

/**
 * @author THRFUR
 * @since 2022-03-01 21:35
 */
public class Index_BF {
    public static void main(String[] args) {
        String A = new String("abcdefg");
        String B = new String("cde");
        System.out.println(Index_BF(A, B)); // 2
    }

    public static int Index_BF(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int i = 0, j = 0;
        while (i<arr1.length && j<arr2.length) {
            if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else {
                i = i-j+2; // 让i, j分别回溯，不过i要比j大一个
                j = 0;
            }
        }
        // 返回s2串在s1串中的索引位，只有j大于s2串时才说明匹配字符串成功
        if (j >= arr2.length) return i-s2.length();
        else return 0;
    }
}
