package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/3 22:39
 */
public class a10I斐波那契数列 {

//    // 用三个变量迭代
//    public int fib(int n) {
//        if (n < 2) {
//            return n == 1 ? 1 : 0;
//        }
//        int mod = (int) (1e9 + 7);
//        int a = 0;
//        int b = 1;
//        int c = a + b;
//        for (int i = 2; i <= n; i++) {
//            a = b;
//            b = c;
//            c = (a + b) % mod;
//        }
//        return b;
//    }

    public int fib(int n) {
        if (n < 2) {
            return n == 0 ? 0 : 1;
        }
        int mod = (int) (1e9 + 7);
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            a = b;
            b = c;
            c = (a + b) % mod;
        }
        return c;
    }

}
