package juc.创建线程池;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author dongboy
 * @what time    2023/1/5 23:08
 */
public class 创建线程池的方式 {

}

class One {

    // 创建固定大小的线程池
    public static void main(String[] args) {
        // 创建大小为5的线程池
        ExecutorService threadPoll = Executors.newFixedThreadPool(5);
        // 使用线程池执行任务
        for (int i = 0; i < 5; i++) {
            // 给线程池添加任务
            threadPoll.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务被执行，线程：" + Thread.currentThread().getName());
                }
            });
        }
        threadPoll.shutdown();
    }

}

class Two {

    // 创建单个线程的线程池，能保证先进先出的顺序
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService threadPoll = Executors.newSingleThreadExecutor();
        // 向线程池添加线程任务
        for (int i = 0; i < 5; i++) {
            threadPoll.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务被执行，线程：" + Thread.currentThread().getName());
                }
            });
        }
        threadPoll.shutdown();
    }

}

class Three {

    // 创建可缓存的线程池，若线程数比需要的线程数还多，则回收，当线程数不够时会新建线程
    // 能复用线程，不必频繁的创建销毁线程
    // 提供了任务队列和拒绝策略
    public static void main(String[] args) {
        // 创建可缓存的线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 执行线程任务
        for (int i = 0; i < 5; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务被执行，线程：" + Thread.currentThread().getName());
                }
            });
        }
        threadPool.shutdown();
    }

}

class Four {

    // 创建能延时执行任务的线程池
    public static void main(String[] args) {
        // 创建线程池
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        System.out.println("执行之前的时间：" + new Date());
        // 添加线程任务，并执行执行时间
        threadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务被执行，线程：" + Thread.currentThread().getName() + " 执行时间：" + new Date());
            }
        }, 1, TimeUnit.SECONDS);
        threadPool.shutdown();
    }

}

class Five {

    // 单线程的能执行延时任务的线程池
    public static void main(String[] args) {
        // 创建线程池
        ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
        System.out.println("执行之前的时间：" + new Date());
        threadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务被执行，线程：" + Thread.currentThread().getName() + " 执行时间：" + new Date());
            }
        }, 1, TimeUnit.SECONDS);
        threadPool.shutdown();
    }

}

class Six {

    // 抢占式的线程池，执行顺序不确定，在jdk 1.8+才能使用
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService threadPool = Executors.newWorkStealingPool();
        // 添加任务
        for (int i = 0; i < 8; i++) {
            int cur = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(cur + "任务被执行，线程：" + Thread.currentThread().getName());
                }
            });
        }
        // 守护线程，JVM不会等待守护线程结束，确保任务完成
        while (!threadPool.isTerminated()) {

        }
    }

}

class Seven {

    // 手动创建线程池
    public static void main(String[] args) {
        // 创建线程池，包括7种核心参数
        // 核心线程数
        // 最大线程数
        // 闲置可存活时间
        // 时间单位
        // 任务队列
        // 线程工程
        // 拒绝策略
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5,
                10,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1000),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; i++) {
            int cur = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(cur);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }

}
