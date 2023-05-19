package hot100;

import java.util.Map;

/**
 * @Author dongboy
 * @what time    2022/12/11 23:13
 */
public class a198打家劫舍 {
    public static void main(String[] args) {

    }
//
//    // 动态规划:一维数组
//    public int rob(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; i++) {
//            // 今天偷和今天不偷的最大收益，去3最大值
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//        return dp[nums.length - 1];
//    }

    // 动态规划:二维数组(更清晰)
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2]; // dp[i][0] 不偷 dp[i][1] 偷
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        if (n == 1) {
            return Math.max(dp[0][1], dp[0][0]);
        }
        for (int i = 1; i < n; i++) {
            // 今天不偷=max(昨天不偷，昨天偷)
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            // 今天偷=max(昨天不偷今天偷，昨天偷今天不偷)
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

}
