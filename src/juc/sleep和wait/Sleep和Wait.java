package juc.sleep和wait;

/**
 * @Author dongboy
 * @what time    2023/1/26 16:59
 */
public class Sleep和Wait {
    public static void main(String[] args) {
        // sleep让当前线程休眠，可以用在任何地方
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // object对象
        Object object = new Object();

        // wait调用对象的锁
        synchronized (object) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 其他线程调用同一对象上的notify方法唤醒
        synchronized (object) {
            // object.notifyAll();
            object.notify();
        }
    }
}
