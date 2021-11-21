package com.javaCase.TEST;

import java.util.*;

/**
 * @author THRFUR
 * 本地测试，与项目无关
 */

public class Test1 {
    public static void main(String[] args) {
        Person p1 = new Person("THRFUR", 2);
        Map<Person, Integer> map = new HashMap<>();
        map.put(p1,123);
        Person p2 = new Person("THRFUR", 2);
        System.out.println(p1 == p2);  //false
        System.out.println(p1.equals(p2));  //true
        System.out.println(map.get(p1));  //123
        System.out.println(map.get(p2));  //123

    }
}

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 覆写euqals()方法
     * @param obj
     * @return 匹配结果
     */
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return Objects.equals(this.name, p.name) && this.age == p.age;
        } else return false;
    }

    /**
     * 覆写hashCode()方法
     * @return
     */
    public int hashCode() {
        return Objects.hash(name, age);
    }
}