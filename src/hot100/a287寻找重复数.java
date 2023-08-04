package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author dongboy
 * @what time    2023/1/3 12:14
 */
public class a287寻找重复数 {

//    // 借用数据结构(回家等通知解法)
//    public int findDuplicate(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) {
//                return nums[i];
//            }
//            set.add(nums[i]);
//        }
//        return -1;
//    }

//    // 二分查找:[1,n]中，设cnt[i]为小于等于i的数的个数，target是要找的重复数
//    // 则有在[1,target-1]上cnt[i]<=i，在[target,n]上cnt[i]>i
//    public int findDuplicate(int[] nums) {
//        int n = nums.length;
//        int left = 1;
//        int right = n - 1;
//        int res = -1;
//        while (left <= right) {
//            int mid = (left + right) >> 1;
//            // 计算出所有小于等于mid的数的数量
//            int cur = 0;
//            for (int i = 0; i < n; i++) {
//                if (nums[i] <= mid) {
//                    cur++;
//                }
//            }
//            // 如果小于等于mid的数小于mid本身，说明要找的数在后面
//            if (cur <= mid) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//                res = mid;
//            }
//        }
//        return res;
//    }

    // 快慢指针:模拟龟兔赛跑算法
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
