package com.javaCase.TEST.TEST_6;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author THRFUR
 * 本地测试，与项目无关：Stack的使用
 */

public class StackTest {
    public static void main(String[] args) {
        String hex = toHex(12500);
        System.out.println(hex);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque<String> deque = new LinkedList<>();
        String result = "";
        while (n != 0) {
            int remainder = n%16;
            n = n/16;
            if (remainder == 15) {
                deque.push("F");
            } else if (remainder == 14) {
                deque.push("E");
            } else if (remainder == 13) {
                deque.push("D");
            } else if (remainder == 12) {
                deque.push("C");
            } else if (remainder == 11) {
                deque.push("B");
            } else if (remainder == 10) {
                deque.push("A");
            } else deque.push(Integer.toString(remainder));
        }
        while (deque.peek() != null) {
            result += deque.pop();
        }
        return result;
    }
}
