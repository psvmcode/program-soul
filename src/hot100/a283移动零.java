package hot100;

/**
 * @Author dongboy
 * @what time    2022/12/31 12:45
 */
public class a283移动零 {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 1, 2});
    }

//    // 从前往后遍历，把不为0的数都依次填充，最后把后面的位置用0填充
//    public void moveZeroes(int[] nums) {
//        // 非0数的个数
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[res] = nums[i];
//                res++;
//            }
//        }
//        for (int i = res; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//    }

    // 按规矩移动零
    public static void moveZeroes(int[] nums) {
        // left前面都是有序的非零数
        int left = 0;
        // left-right之间都是0
        int right = 0;
        while (right < nums.length) {
            // 如果当前右指针不是0，就把当前数和left交换
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

}
