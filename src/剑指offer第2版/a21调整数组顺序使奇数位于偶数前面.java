package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/13 16:18
 */
public class a21调整数组顺序使奇数位于偶数前面 {

//    // 双指针，原地交换
//    public int[] exchange(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            while (left < right && (nums[left] & 1) == 1) {
//                left++;
//            }
//            while (right > left && (nums[right] & 1) == 0) {
//                right--;
//            }
//            if (left < right) {
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//                left++;
//                right--;
//            }
//        }
//        return nums;
//    }

    // 额外用数组+双指针
    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                res[left++] = nums[i];
            } else {
                res[right--] = nums[i];
            }
        }
        return res;
    }

}
