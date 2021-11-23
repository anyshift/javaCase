package com.javaCase.TEST.TEST_1;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author THRFUR
 * 本地测试，与项目无关：EnumMap的使用
 */

public class EnumMapTest_1 {
    public static void main(String[] args) {
       Map<Person, String> map = new EnumMap<>(Person.class);
       map.put(Person.P1, "第一个人");
       map.put(Person.P2, "第二个人");
       map.put(Person.P3, "第三个人");
       System.out.println(map);
       System.out.println(map.get(Person.P1));
    }
}

enum Person {
    P1, P2, P3;
}