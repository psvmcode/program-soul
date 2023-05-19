package hot100;

import java.util.Map;

/**
 * @Author dongboy
 * @what time    2022/11/10 19:25
 */
public class a53最大子数组和 {
    public static void main(String[] args) {

    }

    //    // 暴力(回家等通知解法) 时间O(n^2) 超时
//    public int maxSubArray(int[] nums) {
//        int res = Integer.MIN_VALUE;
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            // 以当前位置开始的最大连续
//            int temp = Integer.MIN_VALUE;
//            int curSum = 0;
//            for (int j = i; j < n; j++) {
//                curSum += nums[j];
//                temp = Math.max(temp, curSum);
//            }
//            res = Math.max(res, temp);
//        }
//        return res;
//    }

//    // 贪心解法
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int res = Integer.MIN_VALUE;
//        int temp = 0;
//        for (int i = 0; i < n; i++) {
//            temp = Math.max(nums[i], temp + nums[i]); //加当前和不加当前
//            res = Math.max(res, temp);
//        }
//        return res;
//    }

    // 分治算法 todo 待续
    public int maxSubArray(int[] nums) {
        int res = 0;
        return res;
    }

}
