package 剑指offer第2版;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/3/1 20:11
 */
public class a56II数组中数字出现的次数 {

//    // 时间O(n) 空间O(n)
//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        for (int key : map.keySet()) {
//            if (map.get(key) == 1) {
//                return key;
//            }
//        }
//        return -1;
//    }

    // 时间O(n) 空间O(n)
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

}
