package com.javaCase;

import java.lang.reflect.Method;

/**
 * @author THRFUR
 * 使用反射中的 Method 调用 setName 和 setAge 方法
 */

public class reflectMethod {
    public static void main(String[] args) throws Exception {
        String name = "THRFUR";
        int age = 100;
        // TODO：用 Method 调用 Person 的 setName 和 setAge 方法
        Person p = new Person();

        //调用 p.setName(String) 方法
        Method mName = p.getClass().getDeclaredMethod("setName", String.class);
        mName.setAccessible(true); //用于支持调用 <private String name> 字段

        //调用 p.setAge(int) 方法
        Method mAge = p.getClass().getDeclaredMethod("setAge", int.class);
        mAge.setAccessible(true); //用于支持调用 <private int age> 字段

        mName.invoke(p, name); //调用 setName(name) 方法
        mAge.invoke(p, age); //调用 setAge(age) 方法

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