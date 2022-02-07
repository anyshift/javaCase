package com.javaCase.TEST.TEST_13.SwingTest_1;

import javax.swing.*;

/**
 * @author THRFUR
 * @since 2022-02-07 11:40
 */
public class MyDemo {
    public static void main(String[] args) {
        JFrame frame = new MyFrame("Frame");

        //设置frame窗口的关闭模式，关闭即退出
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //设置frame窗口的大小
        frame.setSize(400, 300);

        //窗口可见
        frame.setVisible(true);
    }
}
