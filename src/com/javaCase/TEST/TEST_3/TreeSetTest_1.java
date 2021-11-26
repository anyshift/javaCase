package com.javaCase.TEST.TEST_3;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author THRFUR
 * 本地测试，与项目无关：TreeSet的使用
 */

public class TreeSetTest_1 {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        Person p1 = new Person("THRFUR");
        Person p2 = new Person("FURTHR");
        set.add(p1);
        set.add(p2);
        System.out.println(set);
    }
}
class Person {
    public String name;
    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name;
    }
}
