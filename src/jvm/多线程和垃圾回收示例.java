package jvm;

/**
 * @Author dongboy
 * @what time    2023/5/20 16:01
 */
public class 多线程和垃圾回收示例 {

    public static void main(String[] args) throws InterruptedException {
                Runnable runnable = () -> {
            for (int i = 0; i < 200000000; i++) {
                num++;
            }
        };
        Thread t1 = new Thread(runnable, "测试01线程");
        Thread t2 = new Thread(runnable, "测试02线程");
        t1.start();
        t2.start();
        System.out.println("主线程开始睡觉");
        long start = System.currentTimeMillis();
        Thread.sleep(1000);

        System.out.println("睡醒了, 一共睡了 : " + (System.currentTimeMillis() - start) + " 毫秒");
        System.out.println("打印一下num 看看结果是多少: " + num);
    }

    public volatile static int num = 0;

}
