package com.concurrency.chapter6;

import java.util.concurrent.*;

/*
 * @author：jinsheng
 */
public class TestCallableAndFuture {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        MyTask task = new MyTask();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果:" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }

}
