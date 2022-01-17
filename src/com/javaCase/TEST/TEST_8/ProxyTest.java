package com.javaCase.TEST.TEST_8;

/**
 * 设计模式之代理模式
 * @author THRFUR
 */

public class ProxyTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Proxy proxy = new Proxy(computer);
        proxy.browse();
    }
}

interface Network{
    public void browse();
}

class Computer implements Network{
    @Override
    public void browse() {
        System.out.println("计算机联网");
    }
}

class Proxy implements Network{
    private Network network;

    public Proxy(Network network){
        this.network = network;
    }

    public void check(){
        System.out.println("联网前的检查");
    }

    @Override
    public void browse() {
        check();
        network.browse();
    }
}