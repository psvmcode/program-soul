package 剑指offer第2版;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author dongboy
 * @what time    2023/1/25 15:18
 */
public class a02数组中重复的数字 {

    // 利用set计数
//    public int findRepeatNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) {
//                return nums[i];
//            }
//            set.add(nums[i]);
//        }
//        return -1;
//    }

//    // 排序后计数
//    public int findRepeatNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) {
//                return nums[i];
//            }
//        }
//        return -1;
//    }

    // 数组计数
    public int findRepeatNumber(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (temp[nums[i]] > 0) {
                return nums[i];
            }
            temp[nums[i]]++;
        }
        return -1;
    }
}
