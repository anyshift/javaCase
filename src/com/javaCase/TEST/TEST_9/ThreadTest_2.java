package com.javaCase.TEST.TEST_9;

/**
 * @description 两个线程，输出1-100，交替打印
 * @author THRFUR
 * @create 2022-01-20 21:04
 */

class Print implements Runnable {

    private int number = 0;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                notify(); //另一个进程唤醒阻塞中的进程
                if (number < 100) {
                    number++;
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        wait(); //阻塞一个进程，让另一个进程执行
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
        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();
    }
}
