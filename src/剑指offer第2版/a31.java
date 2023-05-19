package 剑指offer第2版;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author dongboy
 * @what time    2023/2/19 15:16
 */
public class a31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < pushed.length; i++) {
            deque.push(pushed[i]);
            while (!deque.isEmpty() && popped[index] == deque.peek()) {
                index++;
                deque.pop();
            }
        }
        return deque.isEmpty();
    }

//    // 两个指针
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        int one = 0;
//        int two = 0;
//        int n = pushed.length;
//        Deque<Integer> deque = new ArrayDeque<>();
//        while (one < n || two < n) {
//            // 栈顶元素不是当前元素
//            if (deque.isEmpty() || deque.peekFirst() != popped[two]) {
//                if (one < n) {
//                    deque.push(pushed[one++]);
//                } else {
//                    return false;
//                }
//            } else {
//                deque.pollFirst();
//                two++;
//            }
//        }
//        return true;
//    }

}
