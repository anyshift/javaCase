package com.javaCase.TEST.TEST_12;

/**
 * 获取Class实例的四种方式
 * @author THRFUR
 * @since 2022-01-29 11:41
 */

class Person {
    //...
}

class Student extends Person {
    //...
}

public class getClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一
        Class<Person> clazz1 = Person.class;
        System.out.println("clazz1 = " + clazz1); //clazz1 = class com.javaCase.TEST.TEST_12.Person

        //方式二
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass(); //因为p1有可能是多态性，所以泛型使用extends方式
        System.out.println("clazz2 = " + clazz2); //clazz2 = class com.javaCase.TEST.TEST_12.Person

        Person p2 = new Student();
        Class<? extends Person> clazz3 = p2.getClass(); //多态性
        System.out.println("clazz3 = " + clazz3); //clazz3 = class com.javaCase.TEST.TEST_12.Student

        //方式三
        Class<?> clazz4 = Class.forName("com.javaCase.TEST.TEST_12.Person"); //因为此时无法确定forName()参数的类型，所以Class的泛型是‘?’，参数内需使用”完整包名+类名“
        System.out.println("clazz4 = " + clazz4); //clazz4 = class test.test_5.Person

        clazz4 = Class.forName("java.lang.String"); //可以转换Class类型
        System.out.println("clazz4 now = " + clazz4); //clazz4 now = class java.lang.String

        //方式四
        ClassLoader classLoader = getClassTest.class.getClassLoader();
        Class<?> clazz5 = classLoader.loadClass("com.javaCase.TEST.TEST_12.Student");
        System.out.println("clazz5 = " + clazz5); //clazz5 = class com.javaCase.TEST.TEST_12.Student


        /*
        clazz1：class com.javaCase.TEST.TEST_12.Person
        clazz2：class com.javaCase.TEST.TEST_12.Person
        clazz3：class com.javaCase.TEST.TEST_12.Student
        clazz4：从 class com.javaCase.TEST.TEST_12.Person 转换到 class java.lang.String
        clazz5；class com.javaCase.TEST.TEST_12.Student
         */

        //比较四种方式的Class是不是同一类
        System.out.println();
        System.out.println("(clazz1 == clazz2) is " + (clazz1 == clazz2)); //true
        System.out.println("(clazz1 == clazz3) is " + (clazz1 == clazz3)); //false
        System.out.println("(clazz1 == clazz4) is " + (clazz1 == clazz4)); //false，因为clazz4被转换了
        System.out.println("(clazz1 == clazz5) is " + (clazz1 == clazz5)); //false
        System.out.println("(clazz3 == clazz5) is " + (clazz3 == clazz5)); //true
    }
}
