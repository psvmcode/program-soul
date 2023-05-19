package hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author dongboy
 * @what time    2023/1/25 15:04
 */
public class a139单词拆分 {

    // 答案的思路，暂时没理解
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        // dp[i]表示字符串前i个字符组成的字符串能否被拆分为若干个字典中的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
