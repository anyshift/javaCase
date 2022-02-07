package com.javaCase.TEST.TEST_13.SwingTest_2;

import javax.swing.*;

/**
 * @author THRFUR
 * @since 2022-02-07 13:20
 */
public class MyDemo {
    public static void main(String[] args) {
        JFrame frame = new MyFrame("测试");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(600,400);

        frame.setVisible(true);
    }
}
