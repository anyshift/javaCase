package com.javaCase.TEST.TEST_9;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description 用实现Callable接口的方式实现进程的执行
 * @author THRFUR
 * @create 2022-01-21 9:36
 */

class NumIncrease implements Callable {

    private int sum = 0;

    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}

public class ThreadTest_3 {
    public static void main(String[] args) {
        NumIncrease numIncrease = new NumIncrease();

        /**
         * Future接口：
         *      > 可以对具体的Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果等。
         *      > FutureTask是Future接口的唯一的实现子类
         *      > FutureTask同时实现了Runnable、Future接口，它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值。
         */

        FutureTask futureTask = new FutureTask(numIncrease);
        //新建线程用于执行NumIncrease里的call()
        new Thread(futureTask).start();

        try {
            Object sum = futureTask.get(); //得到call()的返回值内容
            System.out.println("sum=" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
