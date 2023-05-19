package hot100;

/**
 * @Author dongboy
 * @what time    2022/10/24 22:50
 */
public class a5最长回文子串 {
    public static void main(String[] args) {

    }

    // 中心开花
    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            // 以当前字符为中心
            int left = i;
            int right = i;
            while (left - 1 >= 0 && right + 1 < s.length()) {
                if (s.charAt(left - 1) == s.charAt(right + 1)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (right - left + 1 > res.length()) {
                res = s.substring(left, right + 1);
            }
            // 以当前和右边字符为中心
            if (s.charAt(i) == s.charAt(i + 1)) {
                left = i;
                right = i + 1;
                while (left - 1 >= 0 && right + 1 < s.length()) {
                    if (s.charAt(left - 1) == s.charAt(right + 1)) {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
                if (right - left + 1 > res.length()) {
                    res = s.substring(left, right + 1);
                }
            }
        }
        return res;
    }
}
