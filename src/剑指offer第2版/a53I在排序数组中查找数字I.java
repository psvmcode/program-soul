package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/19 16:49
 */
public class a53I在排序数组中查找数字I {

//    // O(n)
//    public int search(int[] nums, int target) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > target && res > 0) {
//                return res;
//            }
//            if (nums[i] == target) {
//                res++;
//            }
//        }
//        return res;
//    }

    // O(logn):二分+中心开花
    public int search(int[] nums, int target) {
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                int one = mid;
                int two = mid;
                while (one > 0 && nums[one] == nums[one - 1]) {
                    one--;
                }
                while (two < nums.length - 1 && nums[two] == nums[two + 1]) {
                    two++;
                }
                return two - one + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

}
