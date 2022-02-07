package com.javaCase;

/**
 * 静态代理
 * @author THRFUR
 * @since 2022-01-29 21:06
 */

interface Factory {
    public void produceWhat();
}

//被代理类
class PhoneFactory implements Factory {

    @Override
    public void produceWhat() {
        System.out.println("生产手机");
    }
}

//代理类
class proxyFactory implements Factory {

    private Factory factory;

    public proxyFactory(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void produceWhat() {
        System.out.println("生产手机前采购零部件");
        factory.produceWhat();
        System.out.println("手机生产完成");
    }
}

public class staticProxyTest {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        proxyFactory proxy = new proxyFactory(phoneFactory); //参数实现了多态性
        proxy.produceWhat();
    }
}
