package 剑指offer第2版;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author dongboy
 * @what time    2023/2/26 12:14
 */
public class a57和为s的两个数字 {

//    // set
//    public int[] twoSum(int[] nums, int target) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(target - nums[i])) {
//                return new int[]{target - nums[i], nums[i]};
//            }
//            set.add(nums[i]);
//        }
//        return new int[]{-1, -1};
//    }

    // 二分
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int cur = nums[left] + nums[right];
            if (cur == target) {
                return new int[]{nums[left], nums[right]};
            } else if (cur > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

}
