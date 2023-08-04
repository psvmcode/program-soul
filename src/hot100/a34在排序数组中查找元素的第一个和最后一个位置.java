package hot100;

/**
 * @Author dongboy
 * @what time    2022/11/2 19:42
 */
public class a34在排序数组中查找元素的第一个和最后一个位置 {

    // 二分+中心开花解法
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                int i = mid;
                int j = mid;
                while (i - 1 >= 0 && nums[i - 1] == target) {
                    i--;
                }
                while (j + 1 < nums.length && nums[j + 1] == target) {
                    j++;
                }
                return new int[]{i, j};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

//    // 暴力(面试等通知解法)
//    public int[] searchRange(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                int j = i;
//                while (j + 1 < nums.length && nums[j + 1] == target) {
//                    j++;
//                }
//                return new int[]{i, j};
//            }
//        }
//        return new int[]{-1, -1};
//    }

}
