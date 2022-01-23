package com.javaCase.ComparableAndComparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较器之Comparator
 * @author THRFUR
 * @create 2022-01-23 10:03
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Books[] books = new Books[] {
                new Books("Core Java", 200),
                new Books("Effective Java", 189),
                new Books("Effective Java", 179),
                new Books("Mysql", 210)
        };

        //new一个Comparator匿名对象，泛型参数为Books类
        Arrays.sort(books, new Comparator<Books>() {
            @Override
            public int compare(Books o1, Books o2) {
                if (o1 instanceof Books && o2 instanceof Books) {
                    Books b1 = (Books) o1;
                    Books b2 = (Books) o2;
                    if (b1.getBookName().equals(b2.getBookName())) {
                        return Integer.compare(b1.getBookPrice(), b2.getBookPrice());
                    } else return b1.getBookName().compareTo(b2.getBookName());
                } else throw new RuntimeException("传入的类型不一致");
            }
        });

        System.out.println(Arrays.toString(books));
    }
}
class Books{
    private String bookName;
    private int bookPrice;

    public Books(String bookName, int bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                "}\n";
    }
}
