package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2022/11/30 11:29
 */
public class a76最小覆盖子串 {

    // 滑动窗口解法
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char data : t.toCharArray()) {
            map2.put(data, map2.getOrDefault(data, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        int one = 0;
        int two = -1;
        int left = 0;
        int right = -1;
        while (right < s.length()) {
            // 每次判断是否长度达标
            if (right - left + 1 < t.length()) {
                // 加一个右边的字符进来
                right++;
                if (right < s.length()) {
                    map1.put(s.charAt(right), map1.getOrDefault(s.charAt(right), 0) + 1);
                } else {
                    break;
                }
                continue;
            }
            // 到这里说明长度达到了t的长度
            boolean flag = true;
            for (char data : map2.keySet()) {
                if (!map1.containsKey(data)) {
                    flag = false;
                    break;
                }
                if (map1.get(data) < map2.get(data)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (right - left + 1 < min) {
                    one = left;
                    two = right;
                    min = right - left + 1;
                }
                map1.put(s.charAt(left), map1.get(s.charAt(left)) - 1);
                left++;
            } else {
                right++;
                if (right < s.length()) {
                    map1.put(s.charAt(right), map1.getOrDefault(s.charAt(right), 0) + 1);
                } else {
                    break;
                }
            }
        }
        return s.substring(one, two + 1);
    }

//    // 暴力(回家等通知解法)
//    public String minWindow(String s, String t) {
//        int left = 0;
//        int right = 0;
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + t.length() - 1; j < s.length(); j++) {
//                if (method(s.substring(i, j + 1), t)) {
//                    if (s.substring(i, j + 1).length() < min) {
//                        min = j - i + 1;
//                        left = i;
//                        right = j + 1;
//                    }
//                    break;
//                }
//            }
//        }
//        return s.substring(left, right);
//    }
//
//    public boolean method(String cur, String t) {
//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();
//        for (char data : cur.toCharArray()) {
//            map1.put(data, map1.getOrDefault(data, 0) + 1);
//        }
//        for (char data : t.toCharArray()) {
//            map2.put(data, map2.getOrDefault(data, 0) + 1);
//        }
//        for (char data : map2.keySet()) {
//            if (!map1.containsKey(data)) {
//                return false;
//            }
//            if (map1.get(data) < map2.get(data)) {
//                return false;
//            }
//        }
//        return true;
//    }

}
