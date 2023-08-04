package juc.死锁;

/**
 * @Author dongboy
 * @what time    2022/12/30 21:43
 */
public class 死锁 {

    // a对象
    public static Object a = new Object();

    // b对象
    public static Object b = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            // 获取对象a的锁
            System.out.println(Thread.currentThread().getName() + "请求" + a + "的锁");
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "获取到" + a + "的锁");
                // 线程等待2s
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 获取对象b的锁
                System.out.println(Thread.currentThread().getName() + "请求" + b + "的锁");
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "获取到" + b + "的锁");
                }
            }
        }).start();

        new Thread(() -> {
            // 获取对象b的锁
            System.out.println(Thread.currentThread().getName() + "请求" + b + "的锁");
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "获取到" + b + "的锁");
                // 线程等待2s
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 获取对象a的锁
                System.out.println(Thread.currentThread().getName() + "请求" + a + "的锁");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "获取到" + a + "的锁");
                }
            }
        }).start();
    }

}
