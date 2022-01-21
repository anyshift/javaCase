package com.javaCase.TEST.TEST_9;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 利用线程池创建线程
 *
 * 线程池相关API：ExecutorService、Executors
 *      > ExecutorService：
 *          - 常见子类：ThreadPoolExecutor
 *          - 常见方法：
 *                 ~ void execute(Runnable command)：执行任务，只用来执行Runnable
 *                 ~ <T>Future<T> submit(Callable<T> task)：执行任务，一般用来执行Callable
 *                 ~ void shutdown()：关闭线程连接池
 *      > Executors：
 *          - 用于创建并返回不同类型的线程池
 *          - 常见方法：
 *                 ~ Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
 *                 ~ Executors.newFixedThreadPool(n)：创建一个可重用固定线程数的线程池
 *                 ~ Executors.newSingleThreadExecutor()：创建一个只有一个线程的线程池
 *                 ~ Executors.newScheduledThreadPool(n)：创建一个线程池，可以定期地执行命令
 *
 * @author THRFUR
 * @create 2022-01-21 10:02
 */

class NumIncrease_Runnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class NumIncrease_Callable implements Callable{

    private int sum = 0;

    @Override
    public Object call() throws Exception {
        for (int i = 11; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }
}

public class ThreadTest_4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        NumIncrease_Runnable runnable = new NumIncrease_Runnable();
        NumIncrease_Callable callable = new NumIncrease_Callable();



        executorService.execute(runnable); //只用于Runnable
        executorService.submit(callable); //一般用于Callable

        executorService.shutdown(); //关闭线程池
    }
}
