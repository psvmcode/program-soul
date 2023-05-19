package 剑指offer第2版;

import java.util.Arrays;

/**
 * @Author dongboy
 * @what time    2023/3/4 10:49
 */
public class a58I翻转单词顺序 {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        int left = 0;
        int right = strs.length - 1;
        while (left < right) {
            String temp = strs[left];
            strs[left] = strs[right];
            strs[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
            if (i != strs.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
