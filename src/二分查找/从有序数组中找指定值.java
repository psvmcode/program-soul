package 二分查找;

/**
 * @Author dongboy
 * @what time    2023/2/12 15:52
 */
public class 从有序数组中找指定值 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 4, 4, 5, 7};
        int target = 4;
        System.out.println(binarySearch(nums, target));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
