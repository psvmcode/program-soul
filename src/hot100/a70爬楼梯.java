package hot100;

/**
 * @Author dongboy
 * @what time    2022/11/21 23:16
 */
public class a70爬楼梯 {

    // 动态规划:dp数组
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n < 2) {
            return 1;
        }
        dp[1] = 2;
        for (int i = 0; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

}
