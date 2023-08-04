package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author dongboy
 * @what time    2022/12/4 21:26
 */
public class a136只出现一次的数字 {

//    // 暴力遍历:用map解决(回家等通知解法)
//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int data : nums) {
//            map.put(data, map.getOrDefault(data, 0) + 1);
//        }
//        for (int data : map.keySet()) {
//            if (map.get(data) == 1) {
//                return data;
//            }
//        }
//        return -1;
//    }

    // 技巧提:位运算,两个相同的数异或后为0,0和任何数异或为任何数
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int data : nums) {
            res ^= data;
        }
        return res;
    }

}
