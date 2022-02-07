package com.javaCase.TEST.TEST_11;

/**
 * @author THRFUR
 * @since 2022-01-28 22:01
 */
public class Person {
    public String name;
    private int age;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("show..");
    }

    private String getNation(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    @Override
    public String toString() {
        return "name = " + name  +
                ", age = " + age;
    }
}
