package 剑指offer第2版;

import com.sun.xml.internal.ws.api.message.Packet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author dongboy
 * @what time    2023/3/1 20:11
 */
public class a56I数组中数字出现的次数 {

//    // 时间O(n) 空间O(n)
//    public int[] singleNumbers(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        int[] res = new int[2];
//        int index = 0;
//        for (Integer key : map.keySet()) {
//            if (map.get(key) == 1) {
//                res[index++] = key;
//            }
//        }
//        return res;
//    }

    // 时间O(n) 空间O(1)
    public int[] singleNumbers(int[] nums) {
        // 先找到所有数字的和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        // 第一个不是1的位
        int first = 1;
        while ((first & sum) == 0) {
            first <<= 1;
        }
        int one = 0;
        int two = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((first & nums[i]) == 0) {
                one ^= nums[i];
            } else {
                two ^= nums[i];
            }
        }
        return new int[]{one, two};
    }

}
