package hot100;

import java.util.Arrays;

/**
 * @Author dongboy
 * @what time    2022/11/16 22:53
 */
public class a62不同路径 {

    // 排列组合解法:机器人一定会一定 m+n-2 步 todo
    public int uniquePaths(int m, int n) {
        // 每次向右走0到n-1步 且必须走n-1步
        // 每次向下走0到m-1步 且必须走m-1步
        // 计算C(m+n-2,m-1)
        int big = 1;
        int a = m + n - 2;
        while (a > 1) {
            big *= (a--);
        }
        int small = 1;
        int b = m - 1;
        while (b > 1) {
            small *= (b--);
        }
        return big / small;
    }

//    // 动态规划:给左边和上面边界赋值1，然后其他位置一次可以由左边和上边移动得来
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 0; i < n; i++) {
//            dp[0][i] = 1;
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

}
