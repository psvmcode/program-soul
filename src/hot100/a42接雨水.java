package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author dongboy
 * @what time    2022/11/5 11:13
 */
public class a42接雨水 {
    public static void main(String[] args) {
    }

    // 双指针解法 时间O(n) 空间O(1) todo 需要理解
    public int trap(int[] height) {
        // 遍历的时候只用到两个最值，可以递推
        int n = height.length;
        int res = 0;
        int left = 0;
        int right = n - 1;
        int leftMax = -1;
        int rightMax = -1;
        while (left <= right) {
            // 每一步更新做左右为止的最大值
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            //当height[left] < height[right]时一定有leftMax < rightMax，因为小的那边往大的那边走，当两者相等时也是right往右走
            // 也就是保持left对应的元素一定小于right对应的元素
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else { //
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

//    // 单调栈解法 时间O(n) 空间O(n)
//    public int trap(int[] height) {
//        int n = height.length;
//        int res = 0;
//        // 将元素下标入栈，且下标对应的元素按照栈底到栈顶递减
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//            int cur = height[i];
//            while (!deque.isEmpty() && cur > height[deque.peek()]) {
//                int top = deque.pop(); // 当前栈顶元素小于当前元素，就可以求当前栈顶下标对应的柱子可以装的水
//                if (deque.isEmpty()) {
//                    break; // 说明栈内只有一个元素，且这个元素对应的下标最大
//                }
//                int left = deque.peek(); // 栈顶top元素的下一个元素，且height[left] >= height[top]
//                // 计算下标从left-i之间能装的水，不包括left和i
//                int curHigh = Math.min(height[left], height[i]) - height[top]; // 表示top对应下表能装的水
//                int curWeight = i - left - 1; // todo 宽度的计算不太理解
//                res += curHigh * curWeight;
//            }
//            // 事后一定要把当前下表入栈，因为当前下标对应的柱子未装水
//            deque.push(i);
//        }
//        return res;
//    }

//    // 动态规划:前缀和解法 时间O(n) 空间O(n)
//    public int trap(int[] height) {
//        // 计算每个柱子前后的最高的柱子
//        int n = height.length;
//        int[] left = new int[n];
//        int[] right = new int[n];
//        int leftMax = -1;
//        for (int i = 0; i < n; i++) {
//            leftMax = Math.max(leftMax, height[i]);
//            left[i] = leftMax;
//        }
//        int rightMax = -1;
//        for (int i = n - 1; i >= 0; i--) {
//            rightMax = Math.max(rightMax, height[i]);
//            right[i] = rightMax;
//        }
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            res += Math.max(Math.min(left[i], right[i]) - height[i], 0);
//        }
//        return res;
//    }
}
