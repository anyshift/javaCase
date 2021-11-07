package com.javaCase.reflectField;

import java.lang.reflect.Field;
import java.lang.Class;

/**
 * @author THRFUR
 * 使用反射中的 Filed 给 name 和 age 赋值
 */

public class reflectFiled {
    public static void main(String[] args) throws Exception {
        String name = "THRFUR";
        int age = 100;
        // TODO: 利用反射给 name 和 age 字段赋值
        Person p = new Person();
        Class c = p.getClass();

        Field fName = c.getDeclaredField("name");
        Field fAge = c.getDeclaredField("age");

        fName.setAccessible(true);
        fAge.setAccessible(true);

        fName.set(p, name);
        fAge.set(p, age);

        System.out.println(p.getName()); // "THRFUR"
        System.out.println(p.getAge()); // 100
    }
}

class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}