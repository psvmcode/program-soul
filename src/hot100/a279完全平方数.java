package hot100;

import java.util.Map;

/**
 * @Author dongboy
 * @what time    2022/12/31 12:09
 */
public class a279完全平方数 {
    public static void main(String[] args) {

    }

//    // 动态规划解法
//    public int numSquares(int n) {
//        // dp[i]表示
//        int[] dp = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            // 当前i可以划分的完全平方数-1为cur
//            int cur = Integer.MAX_VALUE;
//            for (int j = 1; j * j <= i; j++) {
//                cur = Math.min(dp[i - j * j], cur);
//            }
//            dp[i] = cur + 1;
//        }
//        return dp[n];
//    }

    // 数学规律解法，一个数最多能被分为4个完全平方数，分为4种情况讨论
    public int numSquares(int n) {
        // 本身就是完全平方数的情况
        if (method1(n)) {
            return 1;
        }
        // 由两个完全平方数组成的情况
        if (method2(n)) {
            return 2;
        }
        // 由4个完全平方数组成，有公式 n == 4^k * (8 * m + 7)
        if (method4(n)) {
            return 4;
        }
        // 最后由3个完全平方数组成的用排除法
        return 3;
    }

    public boolean method1(int n) {
        int temp = (int) Math.sqrt(n);
        return temp * temp == n;
    }

    public boolean method2(int n) {
        for (int i = 1; i <= n; i++) {
            if (method1(n - i * i)) {
                return true;
            }
        }
        return false;
    }

    public boolean method4(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        return n % 8 == 7;
    }


}
