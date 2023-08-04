package hot100;


import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author dongboy
 * @what time    2022/12/1 16:30
 */
public class a84柱状图中最大的矩形 {

//    // 暴力(回家等通知解法)
//    public int largestRectangleArea(int[] heights) {
//        int res = 0;
//        int n = heights.length;
//        for (int i = 0; i < n; i++) {
//            int left = i;
//            int right = i;
//            while (left - 1 >= 0 && heights[left - 1] >= heights[i]) {
//                left--;
//            }
//            while (right + 1 < n && heights[right + 1] >= heights[i]) {
//                right++;
//            }
//            res = Math.max(res, (right - left + 1) * heights[i]);
//        }
//        return res;
//    }

//    // 栈辅助，找到当前位置左(右)边第一个比当前位置小的下标位置
//    public int largestRectangleArea(int[] heights) {
//        Deque<Integer> deque = new ArrayDeque<>();
//        int n = heights.length;
//        int[] left = new int[n];
//        int[] right = new int[n];
//        for (int i = 0; i < n; i++) {
//            // 把栈中比当前元素大的元素下标都清除
//            while (!deque.isEmpty() && heights[i] <= heights[deque.peek()]) {
//                deque.pop();
//            }
//            // 找到左边第一个比当前元素小的下标
//            left[i] = (deque.isEmpty() ? -1 : deque.peek());
//            deque.push(i);
//        }
//        while (!deque.isEmpty()) {
//            deque.pop();
//        }
//        for (int i = n - 1; i >= 0; i--) {
//            // 把栈中比当前元素大的元素下标都清除
//            while (!deque.isEmpty() && heights[i] <= heights[deque.peek()]) {
//                deque.pop();
//            }
//            // 找到右边第一个比当前元素小的下标
//            right[i] = (deque.isEmpty() ? n : deque.peek());
//            deque.push(i);
//        }
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
//        }
//        return res;
//    }

    // 栈辅助+优化，找到当前位置左(右)边第一个比当前位置小的下标位置
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            // 把栈中比当前元素大的元素下标都清除
            while (!deque.isEmpty() && heights[i] <= heights[deque.peek()]) {
                right[deque.peek()] = i;
                deque.pop();
            }
            // 找到左边第一个比当前元素小的下标
            left[i] = (deque.isEmpty() ? -1 : deque.peek());
            deque.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

}


