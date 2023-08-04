package hot100;

import java.util.Arrays;

/**
 * @Author dongboy
 * @what time    2022/11/22 22:10
 */
public class a75颜色分类 {

//    // 回家等通知解法
//    public void sortColors(int[] nums) {
//        Arrays.sort(nums);
//    }

//    // 两次遍历，第一次把所有的0放到数组的头部，第二次把所有的2放到数组的尾部
//    public void sortColors(int[] nums) {
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                int temp = nums[i];
//                nums[i] = nums[index];
//                nums[index] = temp;
//                index++;
//            }
//        }
//        for (int i = index; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                int temp = nums[i];
//                nums[i] = nums[index];
//                nums[index] = temp;
//                index++;
//            }
//        }
//    }

    // 双指针解法，用两个指针分别交换0和1
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[one];
                nums[one] = temp;
                one++;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                if (zero < one) {

                }
            }
        }
    }

}
