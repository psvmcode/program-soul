package hot100;

import com.sun.xml.internal.ws.api.message.Packet;

/**
 * @Author dongboy
 * @what time    2023/1/22 23:56
 */
public class a309最佳买卖股票时机含冷冻期 {

    public int maxProfit(int[] prices) {
        if (prices.length < 3) {
            return prices.length == 1 ? 0 : Math.max(0, prices[1] - prices[0]);
        }
        // dp[i][0]第i天买入 dp[i][1]第i天卖出
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(-prices[0], -prices[1]);
        dp[1][1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; i++) {
            // 第i天买入=max(第i-1天买入，第i-2天卖出+今天买入)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            // 第i天卖出=max(第i-1天卖出，第i-1天买入+今天卖出)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

}
