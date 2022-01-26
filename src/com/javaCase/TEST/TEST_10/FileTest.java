package com.javaCase.TEST.TEST_10;

import java.io.File;

/**
 * 一、判断指定目录下是否有后缀为.jpg的文件，如果有则输出文件名称
 * 二、便利指定目录下的所有文件名称，包括子目录文件中的文件。
 * 三、计算指定目录占用空间的大小
 * 四、删除指定目录及其该目录下的所有文件
 * @author THRFUR
 * @since 2022-01-26 15:57
 */
public class FileTest {
    public static void main(String[] args) {
        File fileBasePath = new File("D:\\FileTest");

        //判断指定目录是否有某后缀文件，有的话输出文件名
        hasSuffix(fileBasePath, "jpg");

        //获取指定目录下的所有文件，包括子目录下的文件
        getFilesAndSubFiles(fileBasePath);

        //计算指定目录占用空间的大小
        System.out.println("\n" + getAllFileSize(fileBasePath));
    }

    public static void hasSuffix(File f, String suffix) {
        String[] list = f.list();
        for (String str : list) {
            if (str.endsWith(suffix)){
                System.out.println("FileName is " + "\"" + str + "\"\n");
            }
        }
    }

    public static void getFilesAndSubFiles(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getFilesAndSubFiles(f);
            } else System.out.println(f.getAbsolutePath());
        }
    }

    public static long getAllFileSize(File file) {
        long size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                size += getAllFileSize(f);
            }
        }
        return size;
    }
}

