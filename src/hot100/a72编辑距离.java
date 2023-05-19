package hot100;

/**
 * @Author dongboy
 * @what time    2022/11/21 23:18
 */
public class a72编辑距离 {
    public static void main(String[] args) {

    }

    // 动态规划
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) {
            return m == 0 ? n : m;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[j][0] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
