package 二分查找;

import java.time.chrono.MinguoDate;
import java.util.Arrays;

/**
 * @Author dongboy
 * @what time    2023/2/12 15:57
 */
public class 从有序数组中找到最后一个不大于指定值的下标 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 4, 4, 5, 7};
        int target = 3;
        System.out.println(binarySearch(nums, target));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                while (mid < nums.length - 1 && nums[mid + 1] == nums[mid]) {
                    mid++;
                }
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

}
