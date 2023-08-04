package hot100;

import java.util.*;

/**
 * @Author dongboy
 * @what time    2022/12/14 22:00
 */
public class a215数组中的第K个最大元素 {

//    // 暴力排序后返回(回家等通知解法)
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

//    // 使用优先队列解题
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
//        for (int i = 0; i < nums.length; i++) {
//            queue.offer(nums[i]);
//        }
//        while (k > 0) {
//            int cur = queue.poll();
//            k--;
//            if (k == 0) {
//                return cur;
//            }
//        }
//        return -1;
//    }


//    // 基于快速排序的选择方法
//    public int findKthLargest(int[] nums, int k) {
//        return quickSelect(nums, 0, nums.length - 1, k);
//    }
//
//    public int quickSelect(int[] nums, int left, int right, int index) {
//        int
//    }

}
