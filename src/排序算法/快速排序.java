package 排序算法;

import 排序算法.common.Output;

/**
 * @Author dongboy
 * @what time    2022/12/16 16:42
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1, 4, 5, 2, 6, 7, 8};
        quickSort(nums1);
        Output.output(nums1);
        System.out.println();
        int[] nums2 = new int[]{3, 2, 1, 4, 5, 2, 6, 7, 8, 1, 3, 2, 1, 3, 4, 6, 7, 7, 857, 564};
        quickSort(nums2);
        Output.output(nums2);
    }

    public static void quickSort(int[] nums) {
        dfs(0, nums.length - 1, nums);
    }

    public static void dfs(int left, int right, int[] nums) {
        // 递归中断条件
        if (left >= right) {
            return;
        }
        // 定义变量保存基准数
        int base = nums[left];
        int l = left;
        int r = right;
        // 当left和right不相遇的时候，就检索
        while (left < right) {
            // 先由right从右往左检索比基准数小的，如果检索到比基准数小的就停下
            // 如果检索到比基准数大的，或者相等的，就继续检索
            // 保证下标有效的情况下进行比较
            while (left < right && nums[right] >= base) {
                right--;
            }
            // 到这里说明条件不成立，right数比基准数小
            // left从左往右检索，
            while (left < right && nums[left] <= base) {
                left++;
            }
            // 代码走到这里，说明left和right都停下了
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        // 上面的while循环条件不成立，会跳出，次数left和right在同一个位置
        // 如果left和right相遇，交换基准数和相遇位置的元素
        // 把相遇位置的元素赋值给基准数这个位置的元素
        nums[l] = nums[left];
        // 把基准位置的元素赋值给相遇位置的元素
        nums[left] = base;
        // 基准数在这里后，左边的数都比基准数小，右边的数都比基准数大

        // 排基准数的左边
        dfs(l, left - 1, nums);
        // 排基准数的右边
        dfs(right + 1, r, nums);
    }

}
