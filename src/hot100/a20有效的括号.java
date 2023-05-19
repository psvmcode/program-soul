package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author dongboy
 * @what time    2022/10/27 22:57
 */
public class a20有效的括号 {

    // 栈匹配
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (deque.isEmpty()) {
                deque.push(cur);
            } else {
                if (cur == ')') {
                    if (deque.peek() == '(') {
                        deque.pop();
                    } else {
                        return false;
                    }
                } else if (cur == ']') {
                    if (deque.peek() == '[') {
                        deque.pop();
                    } else {
                        return false;
                    }
                } else if (cur == '}') {
                    if (deque.peek() == '{') {
                        deque.pop();
                    } else {
                        return false;
                    }
                } else {
                    deque.push(cur);
                }
            }
        }
        return deque.isEmpty();
    }
}
