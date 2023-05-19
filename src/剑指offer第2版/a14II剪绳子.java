package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/4 17:42
 */
public class a14II剪绳子 {

    // 因为Math.max()在需要取模时无法比较大小
    public int cuttingRope(int n) {
        if (n < 4) {
            return n == 3 ? 2 : 1;
        }
        long res = 1;
        int mod = (int) (1e9 + 7);
        while (n > 4) {
            n -= 3;
            res = (res * 3) % mod;
        }
        return (int) (res * n % mod);
    }

}
