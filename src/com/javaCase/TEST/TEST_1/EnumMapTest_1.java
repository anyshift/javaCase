package com.javaCase.TEST.TEST_1;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author THRFUR
 * ���ز��ԣ�����Ŀ�޹أ�EnumMap��ʹ��
 */

public class EnumMapTest_1 {
    public static void main(String[] args) {
       Map<Person, String> map = new EnumMap<>(Person.class);
       map.put(Person.P1, "��һ����");
       map.put(Person.P2, "�ڶ�����");
       map.put(Person.P3, "��������");
       System.out.println(map);
       System.out.println(map.get(Person.P1));
    }
}

enum Person {
    P1, P2, P3;
}