package hot100;

import java.util.*;

/**
 * @Author dongboy
 * @what time    2022/10/20 23:04
 */
public class a3无重复字符的最长子串 {
    public static void main(String[] args) {
    }

    // 用HashMap记录字符串上一次出现的位置(换数据结构存储)
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            left = Math.max(left, map.getOrDefault(cur, -1) + 1);
            res = Math.max(res, i - left + 1);
            map.put(cur, i);
        }
        return res;
    }

    // 用数组记录字符串上一次出现的位置(数组解法)
//    public int lengthOfLongestSubstring(String s) {
//        // 128个长度的数组包含了题目所给的英文字母、数字、符号和空格等字符对应的ASSIC编码
//        int[] last = new int[128];
//        Arrays.fill(last, -1);
//        int res = 0;
//        // 窗口的左边界,left维护了最新的无重复字符的边界位置
//        int left = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int cur = s.charAt(i);
//            // 当前字符上一次出现的位置
//            left = Math.max(left, last[cur] + 1);
//            res = Math.max(res, i - left + 1);
//            // 每次更新当前字符最后出现的位置
//            last[cur] = i;
//        }
//        return res;
//    }

    // 滑动窗口解法 计算以当前位置开始的最长无重复子串(优化解法)
//    public int lengthOfLongestSubstring(String s) {
//        int res = 0;
//        Set<Character> set = new HashSet<>();
//        // 初始表示未开始移动
//        int index = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (i > 0) {
//                // 左指针移动一位
//                set.remove(s.charAt(i - 1));
//            }
//            // 右指针不断向右移动,直到出现重复字符
//            while (index + 1 < s.length() && !set.contains(s.charAt(index + 1))) {
//                set.add(s.charAt(index + 1));
//                index++;
//            }
//            res = Math.max(res, index - i + 1);
//        }
//        return res;
//    }

    // 暴力解法：以当前位置开始的最长无重复子串
//    public int lengthOfLongestSubstring(String s) {
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            Set<Character> set = new HashSet<>();
//            for (int j = i; j < s.length(); j++) {
//                if (set.contains(s.charAt(j))) {
//                    res = Math.max(res, j - i);
//                    break;
//                } else {
//                    set.add(s.charAt(j));
//                    res = Math.max(res, j - i + 1);
//                }
//            }
//        }
//        return res;
//    }
}
