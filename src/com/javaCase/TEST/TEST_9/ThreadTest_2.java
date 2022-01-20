package com.javaCase.TEST.TEST_9;

/**
 * @description �����̣߳����1-100�������ӡ
 * @author THRFUR
 * @create 2022-01-20 21:04
 */

class Print implements Runnable {

    private int number = 0;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                notify(); //��һ�����̻��������еĽ���
                if (number < 100) {
                    number++;
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        wait(); //����һ�����̣�����һ������ִ��
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;
            }
        }
    }
}

public class ThreadTest_2 {
    public static void main(String[] args) {
        Print p = new Print();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.setName("��");
        t2.setName("��");
        t1.start();
        t2.start();
    }
}
