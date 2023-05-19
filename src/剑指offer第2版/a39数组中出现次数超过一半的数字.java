package 剑指offer第2版;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/2/21 18:37
 */
public class a39数组中出现次数超过一半的数字 {

//    // 暴力(回家等通知)
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }

    // 遍历
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}
