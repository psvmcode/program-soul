package hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author dongboy
 * @what time    2022/12/10 10:35
 */
public class a239滑动窗口最大值 {
    public static void main(String[] args) {

    }

    // 利用队列维护滑动窗口最大值，保证队列内下标对应的元素递减，且首尾元素之和在k
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        // 利用双端队列结构特点，从两端操作元素，存放或删除下标
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 看是否已经走了k哥元素
            if (i < k - 1) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                continue;
            }
            // 到这里说明下标已经走了k个元素
            // 移除队尾比当前元素小的下标
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 移除从当前下标开始往前k个元素外的下标
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // 保证队列内元素降序，且只包含最近k个下标后，把当前装进来
            deque.offerLast(i);
            res[index++] = nums[deque.peekFirst()];
        }
        return res;
    }
}
