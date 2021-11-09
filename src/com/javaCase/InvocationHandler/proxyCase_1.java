package com.javaCase.InvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author THRFUR
 * 第一个有关动态代理的案例
 */

public class proxyCase_1 {
    public static void main(String[] args) {
        ProxyHandler proxy = new ProxyHandler();
        People people = (People) proxy.bind(new Man());
        people.Name();
    }
}
interface People {
    void Name();
}

class Man implements People {
    public void Name() { System.out.println("THRFUR"); }
}

class ProxyHandler implements InvocationHandler {
    private Object targetHandler;

    /**
     *
     * @param target 绑定的对象
     * @return 代理类
     */

    public Object bind(Object target) {
        this.targetHandler = target;
        return Proxy.newProxyInstance(
                targetHandler.getClass().getClassLoader(),
                targetHandler.getClass().getInterfaces(),
                this
        );
    }

    /**
     *
     * @param proxy 被代理的对象
     * @param method 要调用的方法
     * @param args 方法调用时所需要的参数
     * @return method.invoke
     * @throws Throwable Throwable是Error和Exception的父类，用来定义所有可以作为异常被抛出来的类。
     */

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /* 在调用具体函数方法前，执行功能处理 */
        if ("Name".equals(method.getName())){
            System.out.println("=== before ===");
        }

        Object result = method.invoke(targetHandler, args);

        /* 在调用具体函数方法后，执行功能处理 */
        if ("Name".equals(method.getName())){
            System.out.println("=== after ===");
        }

        return result;
    }
}