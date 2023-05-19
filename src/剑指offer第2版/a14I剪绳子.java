package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/4 17:42
 */
public class a14I剪绳子 {

//    // 动态规划
//    public int cuttingRope(int n) {
//        if (n < 4) {
//            return n == 3 ? 2 : 1;
//        }
//        int[] dp = new int[n + 1];
//        dp[2] = 1;
//        for (int i = 3; i <= n; i++) {
//            for (int j = 1; j < i; j++) {
//                // 直接分为两半，一个是j，一个是i-j，分为i-j不拆分和拆分的情况
//                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
//            }
//        }
//        return dp[n];
//    }

    // 动态规划优化，全分为2和3
//    public int cuttingRope(int n) {
//        if (n < 4) {
//            return n == 3 ? 2 : 1;
//        }
//        int[] dp = new int[n + 1];
//        dp[2] = 1;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
//        }
//        return dp[n];
//    }

    public int cuttingRope(int n) {
        if (n < 4) {
            return n == 3 ? 2 : 1;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

}
