package 快速幂;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author dongboy
 * @what time    2023/1/29 12:56
 */
public class Commom {

    // 快速幂
    public static int quickPow(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a;
            }
            a = a * a;
            b >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.unlock();
    }

}
