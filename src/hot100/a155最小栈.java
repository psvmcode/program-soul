package hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @Author dongboy
 * @what time    2023/1/24 19:08
 */
public class a155最小栈 {

}

// 暴力解法，获取最小元素时间O(1)，但是删除元素时时间为O(n)
class MinStack {

    Deque<Integer> deque;
    int minValue;

    public MinStack() {
        deque = new ArrayDeque<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int val) {
        deque.push(val);
        minValue = Math.min(minValue, val);
    }

    public void pop() {
        int cur = deque.pop();
        // 重新定义最小值
        if (cur == minValue) {
            minValue = Integer.MAX_VALUE;
            for (int data : deque) {
                minValue = Math.min(data, minValue);
            }
        }
    }

    public int top() {
        return deque.peekFirst();
    }

    public int getMin() {
        return minValue;
    }
}
