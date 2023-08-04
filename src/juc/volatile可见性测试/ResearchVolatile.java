package juc.volatile可见性测试;

import sun.misc.Unsafe;

/**
 * @Author dongboy
 * @what time    2023/3/9 10:40
 */
public class ResearchVolatile {

    private static boolean flag = true;

    private static Integer count = 0;

    // 保证Java中的可见性，方式有两种：
    // 1.内存屏障(storeload) ---> JVM曾main
    // 2.上下文切换
    // 将count加上volatile关键字修饰
    // 将count设为Long类型 Long类被final修饰，被final修饰的类或者变量能保证可见性
    // 内存屏障storeload

    // Java层面
    // volatile
    // 锁机制 synchronized
    // 当前对共享变量的操作会存在读不到或者不能立即读到，因为涉及都另一个线程对此变量的写操作
    // final 保证不变性，也能保证可见性

    public static void main(String[] args) throws InterruptedException {
        Thread load = new Thread(() -> {
            System.out.println("开始循环");
            while (flag) {
                count++;
                // 加上Thread.yield();后有线程上下文切换，清除线程内的缓存，强制线程读取主内存的变量
            }
            System.out.println("跳出了循环，循环的次数是：" + count);
        });
        Thread refresh = new Thread(() -> {
            flag = false;
            System.out.println("设置flag为false");
        });
        load.start();
        // 先执行A，进入A的循环体
        Thread.sleep(1000);
        refresh.start();
    }

}
