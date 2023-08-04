package hot100;

import java.util.*;

/**
 * @Author dongboy
 * @what time    2022/12/4 20:28
 */
public class a128最长连续序列 {

//    // 暴力:去重后排序(回家等通知解法)
//    public int longestConsecutive(int[] nums) {
//        if (nums.length < 2) {
//            return nums.length;
//        }
//        Set<Integer> set = new HashSet<>();
//        for (int data : nums) {
//            set.add(data);
//        }
//        int res = 1;
//        List<Integer> list = new ArrayList<>(set);
//        Collections.sort(list);
//        int index = 1;
//        int temp = 1;
//        while (index < list.size()) {
//            if (list.get(index) == list.get(index - 1) + 1) {
//                temp++;
//            } else {
//                temp = 1;
//            }
//            res = Math.max(res, temp);
//            index++;
//        }
//        return res;
//    }

//    // 利用Set集合判断元素是否存在的特点
//    public int longestConsecutive(int[] nums) {
//        if (nums.length < 2) {
//            return nums.length;
//        }
//        Set<Integer> set = new HashSet<>();
//        for (int data : nums) {
//            set.add(data);
//        }
//        int res = 0;
//        for (int data : set) {
//            // 确保当前数是当前连续序列中的最大数
//            if (!set.contains(data + 1)) {
//                int temp = 1;
//                // 从当前一直找到最后，看有几个连续
//                while (set.contains(data - 1)) {
//                    temp++;
//                    data--;
//                }
//                res = Math.max(res, temp);
//            }
//        }
//        return res;
//    }

    // 快慢指针解题
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);
        int slow = 0;
        int fast = 1;
        int res = 1;
        while (fast < nums.length) {
            // 找到第一个不等于前面一个数的位置
            if (nums[fast] == nums[fast - 1]) {
                fast++;
                slow++;
                continue;
            }
            if (nums[fast] == nums[fast - 1] + 1) {
                fast++;
                res = Math.max(res, fast - slow);
            } else {
                slow = fast;
                fast++;
            }
        }
        return res;
    }

}
