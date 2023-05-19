package hot100;

/**
 * @Author dongboy
 * @what time    2022/11/2 16:11
 */
public class a31下一个排列 {
    public static void main(String[] args) {

    }

    // 技巧题：从后往前，找到第一个无序的元素下标i，然后找到后面第一个大于它的元素下标j，两者交换元素值后，反转i后面的所有元素
    public void nextPermutation(int[] nums) {
        //从后往前找到第一个降序的
        int i = -1;
        int n = nums.length;
        for (int index = n - 1; index > 0; index--) {
            if (nums[index] > nums[index - 1]) {
                i = index - 1;
                break;
            }
        }
        if (i == -1) {
            // 说明已经达到降序，反转后即可
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return;
        }
        int j = 0;
        for (int index = n - 1; index >= 0; index--) {
            if (nums[index] > nums[i]) {
                j = index;
                break;
            }
        }
        // 交换i和j位置的下标
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        // 反转i后面的所有元素
        int left = i + 1;
        int right = n - 1;
        while (left < right) {
            int tempLast = nums[left];
            nums[left] = nums[right];
            nums[right] = tempLast;
            left++;
            right--;
        }
    }
}
