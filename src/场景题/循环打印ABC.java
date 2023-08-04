package 场景题;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author dongboy
 * @what time    2023/2/2 20:00
 */
public class 循环打印ABC {

    public static void main(String[] args) throws InterruptedException {
        // 使用单个线程的线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
            }
        };
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("C");
            }
        };
        threadPool.submit(r2);
        threadPool.submit(r1);
        threadPool.submit(r3);
        threadPool.shutdown();

    }
}
