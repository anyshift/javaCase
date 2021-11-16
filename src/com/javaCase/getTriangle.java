package com.javaCase;

import java.util.Scanner;

/**
 * @author THRFUR
 * ������������͵�������
 */

public class getTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("���������������");
        int layer = sc.nextInt();
        Triangle triangle = new Triangle(layer);

        System.out.println("1.��������  2.��������");
        System.out.print("   ��ѡ��1��2��");
        int type = sc.nextInt();
        switch (type) {
            case 1:
                triangle.normalTriangle();
                break;
            case 2:
                triangle.reverseTriangle();
                break;
            default:
                System.out.println("��������...");
        }
    }
}

class Triangle{
    private int layer;
    public Triangle(int layer){
        this.layer = layer;
    }

    public void normalTriangle() {
        for (int i = 1; i <= layer; i++) { //����
            for (int j = 0; j < layer - i; j++) { //ÿ�пո���
                System.out.print(" ");
            }
            for (int k = 0; k < (i*2)-1; k++) { //ÿ�з�����(��ǰһ�ж�����)
                System.out.print("*");
            }
            System.out.println(""); //ÿ�����һ�оͻ���
        }
    }

    public void reverseTriangle() {
        // TODO
    }
}