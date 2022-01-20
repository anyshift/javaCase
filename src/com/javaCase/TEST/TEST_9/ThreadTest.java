package com.javaCase.TEST.TEST_9;

/**
 * @description �����������ֱ���ͬһ���˻���3000��ÿ�δ�1000����3�Ρ�ÿ�δ����ӡ���
 * @author THRFUR
 * @create 2022-01-20 20:33
 */

class Account {

    private int salary = 0;

    public int getSalary() {
        return salary;
    }

    public synchronized void setSalary(int salary) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.salary += salary;
    }
}

class Consumer extends Thread {

    private Account acc;

    public Consumer(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc.setSalary(1000);
            System.out.println(getName() + ": " + acc.getSalary());
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Account account = new Account();
        Consumer c1 = new Consumer(account);
        Consumer c2 = new Consumer(account);
        c1.setName("��");
        c2.setName("��");
        c1.start();
        c2.start();
    }
}
