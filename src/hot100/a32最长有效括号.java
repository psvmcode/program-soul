package hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author dongboy
 * @what time    2022/11/2 16:46
 */
public class a32最长有效括号 {
    public static void main(String[] args) {

    }

    // 数学思路解题:只要到当前位置位置右括号的数量不大于左括号，一旦左右括号数量相等，则一定符合规则
    public int longestValidParentheses(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                res = Math.max(res, 2 * left);
            }
            if (left < right) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                res = Math.max(res, 2 * left);
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return res;
    }

    // 栈解题 保持栈底元素为最后一个没有匹配的右括号的下标
//    public int longestValidParentheses(String s) {
//        int res = 0;
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.offer(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') { // 遇到左括号直接入栈
//                deque.push(i);
//            } else { // 碰到右括号，此时栈顶有三种情况
//                deque.pop();
//                if (deque.isEmpty()) { // 如果只有一个元素，那么一定是右括号，直接弹出即可
//                    deque.push(i);
//                } else { // 如果还有元素，一定是左括号，不可能有连续的右括号下标在栈内
//                    res = Math.max(res, i - deque.peek());
//                }
//            }
//        }
//        return res;
//    }

//    // 动态规划，以当前位置结尾的最长有效括号
//    public int longestValidParentheses(String s) {
//        // 以当前位置结尾的最长有效括号
//        int n = s.length();
//        int[] dp = new int[n];
//        int res = 0;
//        for (int i = 1; i < n; i++) {
//            if (s.charAt(i) == ')') {
//                // 找以前面一个位置结尾的有效阔号的前一个位置
//                int index = i - dp[i - 1] - 1;
//                if (index >= 0 && s.charAt(index) == '(') {
//                    dp[i] = dp[i - 1] + 2;
//                    // 同时再往前考虑一个位置，加上以这个位置结尾的最大有效括号
//                    if (index - 1 >= 0) {
//                        dp[i] += dp[index - 1];
//                    }
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }
}
