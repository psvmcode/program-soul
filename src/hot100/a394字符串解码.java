package hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author dongboy
 * @what time    2022/12/9 18:37
 */
public class a394字符串解码 {
    public static void main(String[] args) {

    }

    // 栈解题:自己的思路，比较混乱
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 遇到右括号就取出栈内的元素
            if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder();
                while (stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                stack.pop();
                temp.reverse();
                // 次数
                int times = 0;
                int num = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    times = times + (stack.pop() - '0') * num;
                    num *= 10;
                }
                while (times > 0) {
                    for (int j = 0; j < temp.length(); j++) {
                        stack.push(temp.charAt(j));
                    }
                    times--;
                }
            } else {
                // 否则存入当前字符
                stack.push(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
