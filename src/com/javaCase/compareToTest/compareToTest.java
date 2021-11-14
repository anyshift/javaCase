package com.javaCase.compareToTest;

import java.util.Arrays;

/**
 * @author THRFUR
 * 具体详情，请浏览 https://www.thrfur.com/d/111
 */

public class compareToTest {
    public static void main(String[] args) {
        Person[] person = new Person[] {
                new Person("Anna", 12),
                new Person("Tina", 31),
                new Person("Jack", 25),
        };
        Arrays.sort(person);
        System.out.println(Arrays.toString(person));
    }
}


class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     *
     * @param other Person对象
     * @return 比较的大小结果
     */

    public int compareTo(Person other) {
        /**
         * 按名字字母排序
         * return this.name.compareTo(other.name);
         */

        return this.name.compareTo(other.name);

        /**
         * 按年纪大小排序
         * return (Integer.valueOf(this.age)).compareTo(Integer.valueOf(other.age));
         */
    }
    public String toString() {
        return this.name + ", " + this.age;
    }
}