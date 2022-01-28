package com.javaCase.TEST.TSET_11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射测试
 * @author THRFUR
 * @since 2022-01-28 22:05
 */
public class reflectTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class personClass = Person.class; //Class未指明泛型的话，默认为<Object>

        //1。通过反射，创建Person类的对象
        Constructor cons1 = personClass.getConstructor(String.class, int.class); //调用public类型的构造器
        Object obj = cons1.newInstance("Jack", 11); //Class未指明泛型的话，默认为<Object>
        //System.out.println(obj);

        Person p1 = (Person) obj; //通过强转后就可以调用p1的toString()方法
        System.out.println(p1); // Person{name='Jack', age=11}

        //2. 调用属性
        Field name = personClass.getDeclaredField("name"); //获取Person类中属性名为name的属性
        name.set(p1,"Tom"); //修改name值，从Jack到Tom
        System.out.println(p1); // Person{name='Tom', age=11}

        //3. 调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p1); //show调用p1，此时的show相当于是Method类型的”对象“，p1是”属性“。因为show方法无参，所以

        //4. 调用私有的构造器
        Constructor privateCons = personClass.getDeclaredConstructor(String.class);
        privateCons.setAccessible(true); //能够调用私有的构造器的关键一步
        Object milly = privateCons.newInstance("Milly"); //通过构造器创建对象，返回的是Object类型
        Person p2 = (Person) milly; //强转是为了调用Person类的toString()
        System.out.println(p2); // Person{name='Milly', age=0}

        //5. 调用私有的属性
        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true); //能够调用私有的属性的关键一步
        age.set(p2, 30);
        System.out.println(p2); // Person{name='Milly', age=30}

        //6. 调用私有的方法
        Method getNation = personClass.getDeclaredMethod("getNation", String.class);//getNation方法，含有一个String类型的参数
        getNation.setAccessible(true); //能够调用私有的方法的关键一步
        getNation.invoke(p2, "中国");
        System.out.println();
        String nation = (String) getNation.invoke(p2, "中国"); //获取getNation()的返回值，return前面的语句也会执行输出
        System.out.println("返回值是： " + nation);
    }
}
