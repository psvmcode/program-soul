package 排序算法;

import 排序算法.common.Output;

/**
 * @Author dongboy
 * @what time    2022/12/16 16:16
 */
public class 希尔排序 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1, 4, 5, 2, 6, 7, 8};
        shellSort(nums1);
        Output.output(nums1);
        System.out.println();
    }

    // 希尔排序:在插入排序的基础上，每次间隔几个步长进行插入排序
    public static void shellSort(int[] nums) {
        int n = nums.length;
        // gap代表每次希尔排序的步长
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 在插入排序的基础上，从步长为1变成步长为gap
            for (int i = gap; i < n; i += gap) {
                int insertIndex = i;
                int insertValue = nums[i];
                while (insertIndex - gap >= 0 && insertValue < nums[insertIndex - gap]) {
                    // 把当前元素后移一个步长
                    nums[insertIndex] = nums[insertIndex - gap];
                    insertIndex -= gap;
                }
                nums[insertIndex] = insertValue;
            }
        }
    }

}
