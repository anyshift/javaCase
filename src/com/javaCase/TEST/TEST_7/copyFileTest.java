package com.javaCase.TEST.TEST_7;

import java.io.*;

/**
 * @author THRFUR
 * 利用InputStream和OutputStream，编写一个复制文件的程序，它可以带参数运行
 */

public class copyFileTest {
    /**
     *
     * @param args 需要自定义两个args参数，第一个参数为源文件路径+文件名，第二个参数为目标文件路径+文件名；
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage:\n  java copyFileTest.java <source> <target>");
            System.exit(1);
        }
        copy(args[0], args[1]);
    }

    static void copy(String source, String target) throws IOException {
        // 友情提示：测试时请使用无关紧要的文件
        // TODO:

        try(InputStream input = new FileInputStream(source);OutputStream output = new FileOutputStream(target)) {
            byte[] buffer = new byte[100]; //为了方便，没有计算source的字节大小，而是给定一个size（会导致target文件中用很多空格来填充至100个字节）
            int n = 0;
            while ((n = input.read(buffer)) != -1) {
                output.write(buffer);
            }
        }
    }
}