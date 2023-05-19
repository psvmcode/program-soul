package 排序算法;

import 排序算法.common.Output;

/**
 * @Author dongboy
 * @what time    2022/12/16 12:37
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1, 4, 5, 2, 6, 7, 8};
        selectSort1(nums1);
        Output.output(nums1);

        System.out.println();

    }

    // 传统的选择排序，每次挑选一个最值放到一边，直到挑选完所有的数
    public static void selectSort1(int[] nums) {
        int n = nums.length;
        // i表示选择排序要遍历的次数
        for (int i = 0; i < n - 1; i++) {
            // 当前轮的最小元素
            int min = nums[i];
            // 当前轮最小元素对应的下标
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            // 将当前i对应的下标和最小位置下标对应的数换位置
            if (minIndex != i) {
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
    }
}
