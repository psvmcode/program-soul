package hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author dongboy
 * @what time    2022/10/25 15:08
 */
public class a17电话号码的字母组合 {
    public static void main(String[] args) {
    }

    // 回溯实现，深度优先
    String[] strings = new String[]
            {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        dfs(0, digits, new StringBuilder());
        return res;
    }

    // 回溯体
    public void dfs(int index, String digits, StringBuilder temp) {
        // 结束条件,到达最后一位数字时，把整个字符串存进去
        if (index == digits.length()) {
            res.add(temp.toString());
            return;
        }
        // 当前下标 ---> 对应的数字 ---> 对应的字符串
        int cur = digits.charAt(index) - '0';
        String curStr = strings[cur];
        for (int i = 0; i < curStr.length(); i++) {
            temp.append(curStr.charAt(i));
            dfs(index + 1, digits, temp);
            temp.deleteCharAt(index);// 删除指定索引处的字符
        }
    }

// 队列实现,广度优先
//    public List<String> letterCombinations(String digits) {
//        List<String> res = new ArrayList<>();
//        if (digits.length() == 0) {
//            return res;
//        }
//        String[] strings = new String[]
//                {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        Queue<StringBuilder> queue = new ArrayDeque<>();
//        // 把第一个数字对应的字符放进去
//        for (char data : strings[digits.charAt(0) - '0'].toCharArray()) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(data);
//            queue.offer(sb);
//        }
//        for (int i = 1; i < digits.length(); i++) {
//            // 把当前数字的下个数字拼接进来
//            int size = queue.size();
//            for (int j = 0; j < size; j++) {
//                // 取出当前对头元素，逐渐和下一个字符的每个拼接
//                StringBuilder poll = queue.poll();
//                for (char data : strings[digits.charAt(i) - '0'].toCharArray()) {
//                    StringBuilder temp = new StringBuilder();
//                    temp.append(poll);
//                    temp.append(data);
//                    queue.offer(temp);
//                }
//            }
//        }
//        while (!queue.isEmpty()) {
//            res.add(queue.poll().toString());
//        }
//        return res;
//    }
}
