package hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/11/25 23:21
 */
public class a739每日温度 {
    public static void main(String[] args) {
    }

    // 暴力:回家等通知解法
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        List<Integer>[] lists = new ArrayList[101];
        for (int i = 30; i < 101; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            lists[temperatures[i]].add(i);
        }
        for (int i = 0; i < n; i++) {
            int curNum = temperatures[i];
            // 找到下一个更大温度
            for (int j = curNum + 1; j < 101; j++) {
                if (lists[j].size() == 0) {
                    continue;
                }
                List<Integer> curList = lists[j];
                if (curList.get(curList.size() - 1) < i) {
                    continue;
                }
                // 二分法找到第一个大于的
                int left = 0;
                int right = curList.size() - 1;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (curList.get(mid) > i) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                res[i] = right;
                break;
            }
        }
        return res;
    }

//    // 利用栈实现
//    public int[] dailyTemperatures(int[] temperatures) {
//        // 左右遍历，找下一个
//        int n = temperatures.length;
//        int[] res = new int[n];
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//            // 对于当前栈内元素，看是否有比它更小的元素
//            while (!deque.isEmpty()) {
//                if (temperatures[deque.peek()] < temperatures[i]) {
//                    res[deque.peek()] = i - deque.peek();
//                    deque.pop();
//                } else {
//                    break;
//                }
//            }
//            deque.push(i);
//        }
//        return res;
//    }

}
