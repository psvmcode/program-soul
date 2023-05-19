package juc.CountDownLatch;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Author dongboy
 * @what time    2023/3/9 20:31
 */
public class CountDownLatch的使用 {
//    Integer
    public static void main(String[] args) {
        String str = "";
        str.startsWith("a",1);
        CountDownLatch count = new CountDownLatch(6);
        new Thread(() -> {
            long size = count.getCount();
            for (long i = 0; i < size; i++) {
                System.out.println("开始第" + i + "个");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.countDown();
            }
        }).start();
        new Thread(() -> {
            System.out.println("等待前");
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待后");
        }).start();
        System.out.println("123");
    }
}
