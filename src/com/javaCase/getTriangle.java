package com.javaCase;

import java.util.Scanner;

/**
 * @author THRFUR
 * 输出正金字塔和倒金字塔
 */

public class getTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("输入金字塔层数：");
        int layer = sc.nextInt();
        Triangle triangle = new Triangle(layer);

        System.out.println("1.正金字塔  2.倒金字塔");
        System.out.print("   请选择1或2：");
        int type = sc.nextInt();
        switch (type) {
            case 1:
                System.out.println("");
                triangle.normalTriangle();
                break;
            case 2:
                System.out.println("");
                triangle.reverseTriangle();
                break;
            default:
                System.out.println("输入有误...");
                break;
        }
    }
}

class Triangle{
    private int layer;
    public Triangle(int layer){
        this.layer = layer;
    }

    public void normalTriangle() {
        for (int i = 1; i <= layer; i++) { //行数
            for (int j = 0; j < layer - i; j++) { //每行空格数
                System.out.print(" ");
            }
            for (int k = 0; k < (i*2)-1; k++) { //每行符号数
                System.out.print("*");
            }
            System.out.println(""); //每输出完一行就换行
        }
    }

    public void reverseTriangle() {
        for (int i = 0; i < layer; i++) { //行数
            for (int j = 0; j <= i-1; j++) { //每行空格数
                System.out.print(" ");
            }
            for (int k = 0; k < 2*(layer-i)-1; k++) { //每行符号数
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}