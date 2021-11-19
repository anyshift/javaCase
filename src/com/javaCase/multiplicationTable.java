package com.javaCase;

import java.util.Scanner;

/**
 * @author THRFUR
 * 九九乘法表
 */

public class multiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Table table = new Table();
        System.out.print("Enter line: ");
        int line = sc.nextInt();
        System.out.println();
        table.nineNineTable(line);
    }
}

class Table {
    private int line;

    public Table(){}

    public Table(int line) {
        this.line = line;
    }

    public void nineNineTable(int line) {
        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (j*i) + "\t");
            }
            System.out.println();
        }
    }
}