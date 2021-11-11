package com.javaCase.Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author THRFUR
 * 所涉知识点：注解、异常、反射
 */

public class annotationRangeCheck {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person("Bob", "Beijing", 20);
        Person p2 = new Person("", "Shanghai", 20);
        Person p3 = new Person("Jack", "", 20);
        Person p4 = new Person("Alice", "Shanghai", 199);

        for (Person p : new Person[] { p1, p2, p3, p4 }) {
            try {
                check(p);
                System.out.println("Person " + p + " #checked ok.");
            } catch (IllegalArgumentException e) {
                System.out.println("Person " + p + " #checked failed: " + e);
            }
        }
    }

    /**
     *
     * @param person 待传入的检查对象
     * @throws IllegalArgumentException 抛出不合法的参数异常
     * @throws ReflectiveOperationException 抛出反射操作异常
     */

    static void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
        for (Field field : person.getClass().getFields()) {
            Range range = field.getAnnotation(Range.class); //判断注解Range中的字段是否存在，不存在将返回null
            if (range != null) {
                Object value = field.get(person);
                if (value instanceof String){
                    String s = (String) value;
                    if (s.length() < range.min() | s.length() > range.max()){
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
                if (value instanceof Integer) {
                    int i = (int) value;
                    if (i < range.min() | i > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }
}

/**
 * 定义了 @Range 注解，定义了 name, city, age 的范围
 */

class Person {

    @Range(min = 1, max = 20)
    public String name;

    @Range(max = 10)
    public String city;

    @Range(min = 1, max = 100)
    public int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("{Person: name=%s, city=%s, age=%d}", name, city, age);
    }
}

/**
 * 定义了该注解能应用于字段
 * 定义了该注解的声明周期为仅运行期
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {

    int min() default 0;

    int max() default 255;

}
