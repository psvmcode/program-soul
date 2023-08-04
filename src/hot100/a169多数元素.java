package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2022/12/11 22:19
 */
public class a169多数元素 {

//    // 暴力解法:先排序，然后返回中位数(回家等通知)
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }

//    // 遍历:用HashMap计数
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int data : nums) {
//            map.put(data, map.getOrDefault(data, 0) + 1);
//            if (map.get(data) >= (nums.length + 1) / 2) {
//                return data;
//            }
//        }
//        return -1;
//    }

    // Boyer-Moore投票算法
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int data : nums) {
            if (count == 0) {
                res = data;
            }
            count += (data == res ? 1 : -1);
        }
        return res;
    }

}
