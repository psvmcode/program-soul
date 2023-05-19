package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/3 22:39
 */
public class a10II斐波那契数列 {

//    // 动态规划
//    public int numWays(int n) {
//        if (n < 2) {
//            return 1;
//        }
//        int mod = (int) (1e9 + 7);
//        int a = 0;
//        int b = 1;
//        int c = 1;
//        for (int i = 2; i <= n; i++) {
//            a = b;
//            b = c;
//            c = (a + b) % mod;
//        }
//        return c;
//    }

    // 借用数组，更清晰
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        int mod = (int) (1e9 + 7);
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }

}
