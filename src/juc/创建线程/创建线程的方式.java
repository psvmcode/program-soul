package juc.创建线程;

import java.util.concurrent.*;

/**
 * @Author dongboy
 * @what time    2023/1/5 20:58
 */
public class 创建线程的方式 {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        MyThread2 temp2 = new MyThread2();
        Thread thread2 = new Thread(temp2);
        thread2.start();
        Callable<String> callable = new MyThread3();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread3 = new Thread(futureTask);
        thread3.start();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executorService.shutdown();

    }
}

class MyThread1 extends Thread {
    public MyThread1() {
    }

    @Override
    public void run() {
        System.out.println("继承Thread创建线程");
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }
}

class MyThread3 implements Callable {

    @Override
    public String call() throws Exception {
        System.out.println("实现Callable接口");
        return "实现Callable接口";
    }
}
