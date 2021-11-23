package com.javaCase.TEST.TEST_2;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author THRFUR
 * 本地测试，与项目无关：TreeMap的使用
 */

public class TreeMapTest_1 {
    public static void main(String[] args) {
        Map<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        map.put(new Person("P1"), 20);
        map.put(new Person("P2"), 30);
        map.put(new Person("P3"), 40);
        for (Person key : map.keySet()){
            System.out.println(key);
        }
        System.out.println(map.get(new Person("P3"))); //40
    }
}

class Person {
    public String name;
    public int age;
    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "{Person: " + name + "}";
    }
}
